package br.com.embedded.park.service;

import java.io.Serializable;
import java.util.List;

import br.com.embedded.park.entity.ValorMensalista;

/**
 * 
 * @author - Jader Assis
 *
 */
public interface ValorMensalistaService extends Serializable {

	List<ValorMensalista> findAll();
	
	void saveOrUpdate(ValorMensalista valorMensalista);
}
