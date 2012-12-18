package br.com.embedded.park.service;

import java.io.Serializable;

import br.com.embedded.park.to.VagaTo;

/**
 * 
 * @author Jader Assis
 *
 */
public interface VagaService extends Serializable {

	VagaTo findDadosVagas();
}
