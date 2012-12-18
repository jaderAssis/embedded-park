package br.com.embedded.park.service;

import java.io.Serializable;
import java.util.List;

import br.com.embedded.park.entity.Uf;

/**
 * 
 * @author - Jader Assis
 *
 */
public interface UfService extends Serializable {

	List<Uf>findAll();
	
	Uf findById(Long id);
}
