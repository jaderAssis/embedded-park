package br.com.embedded.park.service;

import java.io.Serializable;

import br.com.embedded.park.entity.Contato;

/**
 * 
 * @author - Jader Assis
 *
 */
public interface ContatoService extends Serializable {

	void salvar(Contato contato);
}
