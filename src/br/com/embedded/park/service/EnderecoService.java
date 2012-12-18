package br.com.embedded.park.service;

import java.io.Serializable;

import br.com.embedded.park.entity.Endereco;

/**
 * 
 * @author - Jader Assis
 *
 */
public interface EnderecoService extends Serializable {

	void salvar(Endereco endereco);
}
