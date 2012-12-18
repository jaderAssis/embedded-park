package br.com.embedded.park.service;

import java.io.Serializable;

import br.com.embedded.park.entity.Veiculo;

/**
 * 
 * @author - Jader Assis
 *
 */
public interface VeiculoService extends Serializable {

	void save(Veiculo veiculo);
	
}
