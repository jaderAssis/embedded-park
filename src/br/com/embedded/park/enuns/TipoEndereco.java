package br.com.embedded.park.enuns;

/**
 * 
 * @author - Jader Assis
 *
 */
public enum TipoEndereco {

	AEROPORTO("Aeroporto"),
	ALAMEDA("Alameda"),
	AREA("Area"),
	AVENIDA("Avenida"),
	CAMPO("Campo"),
	CHACARA("Chacara"),
	COLONIA("Colonia"),
	CONDOMINIO("Condominio"),
	CONJUNTO("Conjunto"),
	DISTRITO("Distrito"),
	ESPLANADA("Esplanada"),
	ESTACAO("Estacao"),
	ESTRADA("Estrada"),
	FAVELA("Favela"),
	FAZENDA("Fazenda"),
	FEIRA("Feira"),
	JARDIM("Jardim"),
	LADEIRA("Ladeira"),
	LAGO("Lago"),
	LOTEAMENTO("Loteamento"),
	MORRO("Morro"),
	NUCLEO("Nucle"),
	PARQUE("Parque"),
	PASSARELA("Passarela"),
	PATIO("Patio"),
	PRACA("Praca"),
	QUADRA("Quadra"),
	RECANTO("Recanto"),
	RESIDENCIAL("Residencial"),
	RODOVIA("Rodovia"),
	RUA("Rua"),
	SETOR("Setor"),
	SITIO("Sitio"),
	TRAVESSA("Travessa"),
	TRECHO("Trecho"),
	TREVO("Trevo"),
	VALE("Vale"),
	VEREDA("Vereda"),
	VIA("Via"),
	VIADUTO("Viaduto"),
	VIELA("Viela"),
	VILA("Vila");
	
	private String descricao;
	
	private TipoEndereco(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
