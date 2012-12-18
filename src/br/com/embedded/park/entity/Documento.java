package br.com.embedded.park.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.embedded.park.enuns.TipoDocumento;


/**
 * 
 * @author - Jader Assis
 *
 */
@Entity
@Table(name = "tb_documento")
public class Documento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String numDocumento;
	private TipoDocumento tipoDocumento;
	private Mensalista mensalista;

	public Documento() {
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


	@Column(name = "num_documento", nullable = false)
	public String getNumDocumento() {
		return this.numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}


	@Column(name = "tipo_documento", nullable = false)
	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mensalista_id", nullable = false)
	public Mensalista getMensalista() {
		return this.mensalista;
	}

	public void setMensalista(Mensalista mensalista) {
		this.mensalista = mensalista;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((numDocumento == null) ? 0 : numDocumento.hashCode());
		result = prime * result
				+ ((tipoDocumento == null) ? 0 : tipoDocumento.hashCode());
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
		Documento other = (Documento) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (numDocumento == null) {
			if (other.numDocumento != null) {
				return false;
			}
		} else if (!numDocumento.equals(other.numDocumento)) {
			return false;
		}
		if (tipoDocumento == null) {
			if (other.tipoDocumento != null) {
				return false;
			}
		} else if (!tipoDocumento.equals(other.tipoDocumento)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "Documento [id=" + id + ", numDocumento=" + numDocumento
				+ ", tipoDocumento=" + tipoDocumento + "]";
	}

}