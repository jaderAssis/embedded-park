package br.com.embedded.park.to;

/**
 * 
 * @author Jader Assis
 *
 */
public class VagaTo {

	private Long totalVagas;
	private Long vagasOcupadas;
	
	public Long getVagasDisponiveis() {
		if ( totalVagas != null && vagasOcupadas != null ) {
			return (totalVagas - vagasOcupadas); 
		}
		return 0L;
	}
	
	public Long getVagasOcupadas() {
		return vagasOcupadas;
	}
	public void setVagasOcupadas(Long vagasOcupadas) {
		this.vagasOcupadas = vagasOcupadas;
	}
	public Long getTotalVagas() {
		return totalVagas;
	}
	public void setTotalVagas(Long totalVagas) {
		this.totalVagas = totalVagas;
	}
	
}
