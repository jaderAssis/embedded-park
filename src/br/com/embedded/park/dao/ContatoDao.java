package br.com.embedded.park.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.embedded.park.entity.Contato;

/**
 * 
 * @author - Jader Assis
 *
 */
public class ContatoDao {

	@Inject
	private EntityManager em;
	
	public void salvar(Contato contato){
		em.persist(contato);
	}
}
