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
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String login;
	private String senha;
	private List<PontoEletronico> pontosEletronicos;
	private List<Grupo> grupos;

	public Usuario() {
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
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	@Column
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	@OneToMany(mappedBy="usuario", fetch = FetchType.LAZY)
	public List<PontoEletronico> getPontosEletronicos() {
		return this.pontosEletronicos;
	}

	public void setPontosEletronicos(List<PontoEletronico> pontosEletronicos) {
		this.pontosEletronicos = pontosEletronicos;
	}


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="tb_usuario_grupo",
		joinColumns={@JoinColumn(name = "usuario_id", nullable = false)},
		inverseJoinColumns={@JoinColumn(name = "grupos_id", nullable = false)})
	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}
		if (senha == null) {
			if (other.senha != null) {
				return false;
			}
		} else if (!senha.equals(other.senha)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha
				+ "]";
	}

}