package br.com.embedded.park.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "tb_mensalista")
public class Mensalista implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date dataFimVigencia;
	private Date dataInicioVigencia;
	private Date dataNacimento;
	private String nome;
	private Cartao cartao;
	private Contato contato;
	private Contrato contrato;
	private Endereco endereco;
	
	//relacionamentos bi-direcionais
	private List<Pagamento> pagamentos;
	private List<Documento> documentos;
	private List<Locacao> locacoes;

	public Mensalista() {
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
	@Column(name = "data_fim_vigencia", nullable = false)
	public Date getDataFimVigencia() {
		return this.dataFimVigencia;
	}

	public void setDataFimVigencia(Date dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "data_inicio_vigencia", nullable = false)
	public Date getDataInicioVigencia() {
		return this.dataInicioVigencia;
	}

	public void setDataInicioVigencia(Date dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "data_nacimento")
	public Date getDataNacimento() {
		return this.dataNacimento;
	}

	public void setDataNacimento(Date dataNacimento) {
		this.dataNacimento = dataNacimento;
	}


	@Column(nullable = false)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contrato_id", nullable = false)
	public Contrato getContrato() {
		return this.contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}


	@OneToMany(mappedBy = "mensalista", fetch = FetchType.LAZY)
	public List<Documento> getDocumentos() {
		return this.documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}


	@OneToMany(mappedBy = "mensalista", fetch = FetchType.LAZY)
	public List<Locacao> getLocacoes() {
		return this.locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}


	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cartao_id", nullable = false)
	public Cartao getCartao() {
		return this.cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}


	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contato_id")
	public Contato getContato() {
		return this.contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}


	@OneToOne(fetch = FetchType.LAZY)
	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@OneToMany(mappedBy = "mensalista", fetch = FetchType.LAZY)
	public List<Pagamento> getPagamentos() {
		return this.pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataFimVigencia == null) ? 0 : dataFimVigencia.hashCode());
		result = prime
				* result
				+ ((dataInicioVigencia == null) ? 0 : dataInicioVigencia
						.hashCode());
		result = prime * result
				+ ((dataNacimento == null) ? 0 : dataNacimento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Mensalista other = (Mensalista) obj;
		if (dataFimVigencia == null) {
			if (other.dataFimVigencia != null) {
				return false;
			}
		} else if (!dataFimVigencia.equals(other.dataFimVigencia)) {
			return false;
		}
		if (dataInicioVigencia == null) {
			if (other.dataInicioVigencia != null) {
				return false;
			}
		} else if (!dataInicioVigencia.equals(other.dataInicioVigencia)) {
			return false;
		}
		if (dataNacimento == null) {
			if (other.dataNacimento != null) {
				return false;
			}
		} else if (!dataNacimento.equals(other.dataNacimento)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "Mensalista [id=" + id + ", dataFimVigencia=" + dataFimVigencia
				+ ", dataInicioVigencia=" + dataInicioVigencia
				+ ", dataNacimento=" + dataNacimento + ", nome=" + nome + "]";
	}

}