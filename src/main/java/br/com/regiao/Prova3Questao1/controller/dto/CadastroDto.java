package br.com.regiao.Prova3Questao1.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.regiao.Prova3Questao1.modelo.Cadastro;
import br.com.regiao.Prova3Questao1.modelo.Regiao;

public class CadastroDto {

	private Long id;
	private String nomeEstado;
	private Regiao regiao;
	private Long populacao;
	private String capital;
	private Long area;

	public CadastroDto(Cadastro cadastro) {
		this.id = cadastro.getId();
		this.nomeEstado = cadastro.getNomeEstado();
		this.regiao = cadastro.getRegiao();
		this.populacao = cadastro.getPopulacao();
		this.capital = cadastro.getCapital();
		this.area = cadastro.getArea();
	}

	public Long getId() {
		return id;
	}

	public String getNomeCidade() {
		return nomeEstado;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public Long getPopulacao() {
		return populacao;
	}

	public String getCapital() {
		return capital;
	}

	public Long getArea() {
		return area;
	}

	public static List<CadastroDto> converter(List<Cadastro> regioes) {
		return regioes.stream().map(CadastroDto::new).collect(Collectors.toList());
	}

}
