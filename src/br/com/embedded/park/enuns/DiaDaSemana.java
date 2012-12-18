package br.com.embedded.park.enuns;

public enum DiaDaSemana {

	SEGUNDA("SEGUNDA", "Segunda"),
	TERCA("TERCA", "Terca"),
	QUARTA("QUARTA", "Quarta"),
	QUINTA("QUINTA", "Quinta"),
	SEXTA("SEXTA", "Sexta"),
	SABADO("SABADO", "Sabado"),
	DOMINGO("DOMINGO", "Domingo");
	
	private DiaDaSemana(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	private String codigo;
	private String descricao;
	
	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
}