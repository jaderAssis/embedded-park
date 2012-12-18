package br.com.embedded.park.service;

import java.io.Serializable;

import br.com.embedded.park.entity.ValorHorista;

/**
 * 
 * @author - Jader Assis
 *
 */
public interface ValorHoristaService extends Serializable {

	ValorHorista find();
	
	void saveOrUpdate(ValorHorista valorHorista);
}
