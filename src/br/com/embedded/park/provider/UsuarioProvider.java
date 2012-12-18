package br.com.embedded.park.provider;

import javax.inject.Inject;

import br.com.embedded.park.dao.UsuarioDao;
import br.com.embedded.park.entity.Usuario;
import br.com.embedded.park.service.UsuarioService;

public class UsuarioProvider implements UsuarioService {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDao usuarioDao;

	/**
	 * Verifica se exite usuario e senha na base de dados
	 * 
	 * @author Jader Assis
	 * @since 04/08/2012 18:42:42
	 *
	 * @param usuario
	 * @return
	 */
	public Usuario existe(Usuario usuario) {
		return usuarioDao.existe(usuario);
	}
	

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	
}
