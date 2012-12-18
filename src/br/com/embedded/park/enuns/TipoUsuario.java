package br.com.embedded.park.enuns;

public enum TipoUsuario {

	ADM("ADM", "ADMINISTRADOR"),
	GER("GER", "GERENTE");
	
	private String codigo;
	private String descricao;
	
	private TipoUsuario(String codigo, String descricao){
		this.setCodigo(codigo);
		this.setDescricao(descricao);
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}