package br.com.embedded.park.enuns;

/**
 * 
 * @author Jader Assis
 *
 */
public enum TipoPessoa {

	PESSOA_FISICA(1, "PF"),
	PESSOA_JURIDICA(2, "PJ");
	
	private TipoPessoa(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	private int codigo;
	private String descricao;
	
	public int getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
}
