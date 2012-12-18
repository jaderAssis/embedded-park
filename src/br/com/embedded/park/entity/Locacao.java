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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * 
 * @author - Jader Assis
 *
 */
@Entity
@Table(name = "tb_locacao")
public class Locacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date dataFim;
	private Date dataInicio;
	private Mensalista mensalista;
	private Veiculo veiculo;
	private Cartao cartao;
	
	//relacionamento bi-direcional
	private Pagamento pagamento;

	
	public Locacao() {
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
	@Column(name = "data_fim")
	public Date getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_inicio", nullable = false)
	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mensalista_id")
	public Mensalista getMensalista() {
		return this.mensalista;
	}

	public void setMensalista(Mensalista mensalista) {
		this.mensalista = mensalista;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="veiculo_id")
	public Veiculo getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	@OneToOne(mappedBy = "locacao", fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "locacao_id", insertable = false, updatable = false)
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cartao", nullable = false)
	public Cartao getCartao() {
		return this.cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result
				+ ((dataInicio == null) ? 0 : dataInicio.hashCode());
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
		Locacao other = (Locacao) obj;
		if (dataFim == null) {
			if (other.dataFim != null) {
				return false;
			}
		} else if (!dataFim.equals(other.dataFim)) {
			return false;
		}
		if (dataInicio == null) {
			if (other.dataInicio != null) {
				return false;
			}
		} else if (!dataInicio.equals(other.dataInicio)) {
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
		return "Locacao [id=" + id + ", dataFim=" + dataFim + ", dataInicio="
				+ dataInicio + "]";
	}
}