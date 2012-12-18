package br.com.embedded.park.service;

import java.io.Serializable;

import br.com.embedded.park.entity.Usuario;

public interface UsuarioService extends Serializable {

	Usuario existe(Usuario usuario);
	
}
