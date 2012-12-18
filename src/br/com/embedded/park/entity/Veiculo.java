package br.com.embedded.park.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * 
 * @author - Jader Assis
 *
 */
@Entity
@Table(name = "tb_veiculo")
public class Veiculo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cor;
	private String modelo;
	private String placa;
	private List<Locacao> locacoes;

	public Veiculo() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(nullable = false)
	public String getCor() {
		return this.cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}


	@Column(nullable = false)
	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	@Column(nullable = false)
	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}


	@OneToMany(mappedBy="veiculo", fetch = FetchType.LAZY)
	public List<Locacao> getLocacoes() {
		return this.locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Veiculo other = (Veiculo) obj;
		if (cor == null) {
			if (other.cor != null) {
				return false;
			}
		} else if (!cor.equals(other.cor)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (modelo == null) {
			if (other.modelo != null) {
				return false;
			}
		} else if (!modelo.equals(other.modelo)) {
			return false;
		}
		if (placa == null) {
			if (other.placa != null) {
				return false;
			}
		} else if (!placa.equals(other.placa)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", cor=" + cor + ", modelo=" + modelo
				+ ", placa=" + placa + "]";
	}
	
}