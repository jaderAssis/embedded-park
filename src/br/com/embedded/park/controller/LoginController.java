package br.com.embedded.park.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.embedded.park.entity.Usuario;
import br.com.embedded.park.service.UsuarioService;

@Named
@RequestScoped
public class LoginController extends BaseController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	
	@Inject
	private transient UsuarioService usuarioService;
	@Inject
	private transient UsuarioLogadoController usuarioLogado;
	
	public LoginController() {
		super();
	}

	public String efetuaLogin() {
		
		usuario = usuarioService.existe(usuario);
		
		if ( usuario != null ) {
			this.usuarioLogado.setUsuario(usuario);
			
			return "/administrar/inicio?faces-redirect=true";
		}
		else {
			this.usuarioLogado.setUsuario(null);
			addMessageErro("login_usuario_senha_invalido");
			
			return "/app/login";
		}
	}
	
	/**
	 * Realiza o logout do usuario na app
	 * 
	 * @author Jader Assis
	 * @since 04/08/2012 19:58:45
	 *
	 * @return
	 */
	public String logout() {
		this.usuarioLogado.setUsuario(null);
		this.usuarioLogado.setGerente(false);
		this.usuarioLogado.setAdministrador(false);
		
		return "/app/login?faces-redirect=true";
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioLogado(UsuarioLogadoController usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public UsuarioLogadoController getUsuarioLogado() {
		return usuarioLogado;
	}

	public boolean isUsuarioLogado() {
		return usuarioLogado.isLogado();
	}

	public boolean isUsuarioAdministrador() {
		return usuarioLogado.isAdministrador();
	}
	
	public boolean isUsuarioGerente() {
		return usuarioLogado.isGerente();
	}
}