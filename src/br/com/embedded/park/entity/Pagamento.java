package br.com.embedded.park.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * @author - Jader Assis
 *
 */
@Entity
@Table(name = "tb_pagamento")
public class Pagamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date data;
	private String tipoPagamento;
	private BigDecimal valor;
	private Mensalista mensalista;
	private Locacao locacao;
	
	public Pagamento() {
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
	@Column(nullable = false)
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	@Column(name = "tipo_pagamento", nullable = false)
	public String getTipoPagamento() {
		return this.tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}


	@Column(nullable = false)
	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mensalista_id")
	public Mensalista getMensalista() {
		return this.mensalista;
	}

	public void setMensalista(Mensalista mensalista) {
		this.mensalista = mensalista;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locacao_id")
	public Locacao getLocacao() {
		return locacao;
	}


	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((tipoPagamento == null) ? 0 : tipoPagamento.hashCode());
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
		Pagamento other = (Pagamento) obj;
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (tipoPagamento == null) {
			if (other.tipoPagamento != null) {
				return false;
			}
		} else if (!tipoPagamento.equals(other.tipoPagamento)) {
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
		return "Pagamento [id=" + id + ", data=" + data + ", tipoPagamento="
				+ tipoPagamento + ", valor=" + valor + "]";
	}
}