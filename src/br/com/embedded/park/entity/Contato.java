package br.com.embedded.park.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 * @author - Jader Assis
 *
 */
@Entity
@Table(name = "tb_contato")
public class Contato implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private String informacaoAdicional;
	private String telefoneCelular;
	private String telefoneComercial;
	private String telefoneResidencial;

	public Contato() {
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

	@Column
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "informacao_adicional")
	public String getInformacaoAdicional() {
		return this.informacaoAdicional;
	}

	public void setInformacaoAdicional(String informacaoAdicional) {
		this.informacaoAdicional = informacaoAdicional;
	}

	@Column(name = "telefone_celular")
	public String getTelefoneCelular() {
		return this.telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	@Column(name = "telefone_comercial")
	public String getTelefoneComercial() {
		return this.telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	@Column(name = "telefone_residencial")
	public String getTelefoneResidencial() {
		return this.telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((informacaoAdicional == null) ? 0 : informacaoAdicional
						.hashCode());
		result = prime * result
				+ ((telefoneCelular == null) ? 0 : telefoneCelular.hashCode());
		result = prime
				* result
				+ ((telefoneComercial == null) ? 0 : telefoneComercial
						.hashCode());
		result = prime
				* result
				+ ((telefoneResidencial == null) ? 0 : telefoneResidencial
						.hashCode());
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
		Contato other = (Contato) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (informacaoAdicional == null) {
			if (other.informacaoAdicional != null) {
				return false;
			}
		} else if (!informacaoAdicional.equals(other.informacaoAdicional)) {
			return false;
		}
		if (telefoneCelular == null) {
			if (other.telefoneCelular != null) {
				return false;
			}
		} else if (!telefoneCelular.equals(other.telefoneCelular)) {
			return false;
		}
		if (telefoneComercial == null) {
			if (other.telefoneComercial != null) {
				return false;
			}
		} else if (!telefoneComercial.equals(other.telefoneComercial)) {
			return false;
		}
		if (telefoneResidencial == null) {
			if (other.telefoneResidencial != null) {
				return false;
			}
		} else if (!telefoneResidencial.equals(other.telefoneResidencial)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "Contato [id=" + id + ", email=" + email
				+ ", informacaoAdicional=" + informacaoAdicional
				+ ", telefoneCelular=" + telefoneCelular
				+ ", telefoneComercial=" + telefoneComercial
				+ ", telefoneResidencial=" + telefoneResidencial + "]";
	}
	
}