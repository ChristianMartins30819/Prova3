package br.com.regiao.Prova3Questao1.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.regiao.Prova3Questao1.modelo.Cadastro;
import br.com.regiao.Prova3Questao1.repository.CadastroRepository;

public class AtualizacaoCadastroForm {

	@NotNull
	@NotEmpty
	private String nomeEstado;
	@NotNull

	private Long populacao;
	@NotNull
	@NotEmpty
	private String capital;
	@NotNull

	private Long area;

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public Long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(Long populacao) {
		this.populacao = populacao;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public Long getArea() {
		return area;
	}

	public void setArea(Long area) {
		this.area = area;
	}

	public Cadastro atualizar(Long id, CadastroRepository cadastroRepository) {
		Cadastro cadastro = cadastroRepository.getById(id);
		cadastro.setNomeEstado(this.nomeEstado);
		cadastro.setPopulacao(this.populacao);
		cadastro.setCapital(this.capital);
		cadastro.setArea(this.area);
		return cadastro;
	}

}
