package br.com.regiao.Prova3Questao1.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.regiao.Prova3Questao1.controller.dto.CadastroDto;
import br.com.regiao.Prova3Questao1.controller.dto.DetalhesCadastroDto;
import br.com.regiao.Prova3Questao1.controller.form.AtualizacaoCadastroForm;
import br.com.regiao.Prova3Questao1.controller.form.CadastroForm;
import br.com.regiao.Prova3Questao1.modelo.Cadastro;
import br.com.regiao.Prova3Questao1.modelo.Regiao;
import br.com.regiao.Prova3Questao1.repository.CadastroRepository;

@RestController
@RequestMapping(value = "/regiao")
public class CadastroController {

	@Autowired
	private CadastroRepository cadastroRepository;

	@GetMapping
	public List<CadastroDto> lista(String nomeEstado) {
		if (nomeEstado == null) {
			List<Cadastro> cadastros = cadastroRepository.findAll();
			return CadastroDto.converter(cadastros);
		} else {
			List<Cadastro> cadastros = cadastroRepository.findByNomeEstado(nomeEstado);
			return CadastroDto.converter(cadastros);
		}
	}

	@GetMapping("/populacao")
	public List<CadastroDto> listarPorPopulacao(Long populacao) {

		List<Cadastro> cadastros = cadastroRepository.listarPorPopulacao(populacao);
		return CadastroDto.converter(cadastros);

	}

	@GetMapping("/area")
	public List<CadastroDto> listarPorArea(Long area) {

		List<Cadastro> cadastros = cadastroRepository.listarPorArea(area);
		return CadastroDto.converter(cadastros);

	}

	@GetMapping("/agrupar")
	public List<CadastroDto> listarPorRegiao(Regiao regiao) {

		List<Cadastro> cadastros = cadastroRepository.listarPorRegiao(regiao);
		return CadastroDto.converter(cadastros);

	}

	@PostMapping
	@Transactional
	public ResponseEntity<CadastroDto> cadastrar(@RequestBody @Valid CadastroForm form,
			UriComponentsBuilder uriBuilder) {
		Cadastro cadastro = form.converter(cadastroRepository);
		cadastroRepository.save(cadastro);

		URI uri = uriBuilder.path("/regiao/{id}").buildAndExpand(cadastro.getId()).toUri();
		return ResponseEntity.created(uri).body(new CadastroDto(cadastro));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesCadastroDto> detalhar(@PathVariable Long id) {
		Optional<Cadastro> optional = cadastroRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new DetalhesCadastroDto(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CadastroDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoCadastroForm form) {
		Optional<Cadastro> optional = cadastroRepository.findById(id);
		if (optional.isPresent()) {
			Cadastro cadastro = form.atualizar(id, cadastroRepository);
			return ResponseEntity.ok(new CadastroDto(cadastro));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Cadastro> optional = cadastroRepository.findById(id);
		if (optional.isPresent()) {
			cadastroRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
