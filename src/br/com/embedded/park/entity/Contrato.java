package br.com.embedded.park.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * 
 * @author - Jader Assis
 *
 */
@Entity
@Table(name = "tb_contrato")
public class Contrato implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date dataContrato;
	private Integer diaVencimentoMensal;
	private BigDecimal valor;

	public Contrato() {
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

	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_contrato", nullable = false)
	public Date getDataContrato() {
		return this.dataContrato;
	}

	public void setDataContrato(Date dataContrato) {
		this.dataContrato = dataContrato;
	}


	@Column(name = "dia_vencimento_mensal", nullable = false)
	public Integer getDiaVencimentoMensal() {
		return this.diaVencimentoMensal;
	}

	public void setDiaVencimentoMensal(Integer diaVencimentoMensal) {
		this.diaVencimentoMensal = diaVencimentoMensal;
	}


	@Column(nullable = false)
	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataContrato == null) ? 0 : dataContrato.hashCode());
		result = prime
				* result
				+ ((diaVencimentoMensal == null) ? 0 : diaVencimentoMensal
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Contrato other = (Contrato) obj;
		if (dataContrato == null) {
			if (other.dataContrato != null) {
				return false;
			}
		} else if (!dataContrato.equals(other.dataContrato)) {
			return false;
		}
		if (diaVencimentoMensal == null) {
			if (other.diaVencimentoMensal != null) {
				return false;
			}
		} else if (!diaVencimentoMensal.equals(other.diaVencimentoMensal)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (valor == null) {
			if (other.valor != null) {
				return false;
			}
		} else if (!valor.equals(other.valor)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", dataContrato=" + dataContrato
				+ ", diaVencimentoMensal=" + diaVencimentoMensal + ", valor="
				+ valor + "]";
	}
	
}