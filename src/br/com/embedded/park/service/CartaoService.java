package br.com.embedded.park.service;

import java.io.Serializable;
import java.util.List;

import br.com.embedded.park.entity.Cartao;

/**
 * 
 * @author - Jader Assis
 *
 */
public interface CartaoService extends Serializable {

	List<Cartao> findAllCartoesLiberados();
	
	List<Cartao> findAll();
	
	Cartao findById(Long id);
	
	Cartao findByCodigo(String codigo);
	
	boolean existeCartao(String codigo);
}
