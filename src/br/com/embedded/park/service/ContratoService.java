package br.com.embedded.park.service;

import java.io.Serializable;

import br.com.embedded.park.entity.Contrato;

/**
 * 
 * @author - Jader Assis
 *
 */
public interface ContratoService extends Serializable {

	void salvar(Contrato contrato);
}
