package br.com.embedded.park.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.embedded.park.entity.Grupo;
import br.com.embedded.park.entity.Usuario;
import br.com.embedded.park.enuns.TipoUsuario;

@Named("usuarioLogado")
@SessionScoped
public class UsuarioLogadoController implements Serializable{

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private boolean gerente;
	private boolean administrador;
	
	/**
	 * Utilizado para setar os atributos do usuario na secao
	 * 
	 * @author Jader Assis
	 * @since 04/08/2012 20:37:07
	 *
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		
		if ( usuario != null && usuario.getGrupos() != null ) {
			for (Grupo grupo : usuario.getGrupos()) {
				if ( TipoUsuario.ADM.getCodigo().equalsIgnoreCase(grupo.getNome()) ) {
					administrador = true;
				}
				else if ( TipoUsuario.GER.getCodigo().equalsIgnoreCase(grupo.getNome()) ) {
					gerente = true;
				}
			}
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public boolean isLogado(){
		return usuario != null;
	}

	public boolean isGerente() {
		return gerente;
	}

	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	
}
