package br.com.regiao.Prova3Questao1.controller.dto;

import br.com.regiao.Prova3Questao1.modelo.Cadastro;
import br.com.regiao.Prova3Questao1.modelo.Regiao;

public class DetalhesCadastroDto {

	private Long id;
	private String nomeEstado;
	private Regiao regiao;
	private Long populacao;
	private String capital;
	private Long area;

	public DetalhesCadastroDto(Cadastro cadastro) {
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

	public String getNomeEstado() {
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

}
