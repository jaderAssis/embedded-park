package br.com.embedded.park.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * 
 * @author - Jader Assis
 *
 */
@Entity
@Table(name = "tb_ponto_eletronico")
public class PontoEletronico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date dataEntrada;
	private Date dataSaida;
	private Date dataSaidaAlmoco;
	private Date dataVoltaAlmoco;
	private Usuario usuario;

	public PontoEletronico() {
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


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_entrada")
	public Date getDataEntrada() {
		return this.dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_saida")
	public Date getDataSaida() {
		return this.dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}


	@Column(name = "data_saida_almoco")
	public Date getDataSaidaAlmoco() {
		return this.dataSaidaAlmoco;
	}

	public void setDataSaidaAlmoco(Date dataSaidaAlmoco) {
		this.dataSaidaAlmoco = dataSaidaAlmoco;
	}


	@Column(name = "data_volta_almoco")
	public Date getDataVoltaAlmoco() {
		return this.dataVoltaAlmoco;
	}

	public void setDataVoltaAlmoco(Date dataVoltaAlmoco) {
		this.dataVoltaAlmoco = dataVoltaAlmoco;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataEntrada == null) ? 0 : dataEntrada.hashCode());
		result = prime * result
				+ ((dataSaida == null) ? 0 : dataSaida.hashCode());
		result = prime * result
				+ ((dataSaidaAlmoco == null) ? 0 : dataSaidaAlmoco.hashCode());
		result = prime * result
				+ ((dataVoltaAlmoco == null) ? 0 : dataVoltaAlmoco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PontoEletronico other = (PontoEletronico) obj;
		if (dataEntrada == null) {
			if (other.dataEntrada != null) {
				return false;
			}
		} else if (!dataEntrada.equals(other.dataEntrada)) {
			return false;
		}
		if (dataSaida == null) {
			if (other.dataSaida != null) {
				return false;
			}
		} else if (!dataSaida.equals(other.dataSaida)) {
			return false;
		}
		if (dataSaidaAlmoco == null) {
			if (other.dataSaidaAlmoco != null) {
				return false;
			}
		} else if (!dataSaidaAlmoco.equals(other.dataSaidaAlmoco)) {
			return false;
		}
		if (dataVoltaAlmoco == null) {
			if (other.dataVoltaAlmoco != null) {
				return false;
			}
		} else if (!dataVoltaAlmoco.equals(other.dataVoltaAlmoco)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "PontoEletronico [id=" + id + ", dataEntrada=" + dataEntrada
				+ ", dataSaida=" + dataSaida + ", dataSaidaAlmoco="
				+ dataSaidaAlmoco + ", dataVoltaAlmoco=" + dataVoltaAlmoco
				+ "]";
	}
	
}