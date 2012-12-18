package br.com.embedded.park.service;

import java.io.Serializable;

import br.com.embedded.park.entity.Documento;

/**
 * 
 * @author - Jader Assis
 *
 */
public interface DocumentoService extends Serializable {

	void salvar(Documento documento);
}
