package br.com.embedded.park.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.embedded.park.entity.Contrato;

/**
 * 
 * @author - Jader Assis
 *
 */
public class ContratoDao {

	@Inject
	private EntityManager em;
	
	public void salvar(Contrato contrato) {
		em.persist(contrato);
	}
}
