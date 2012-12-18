package br.com.embedded.park.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.embedded.park.entity.Endereco;

/**
 * 
 * @author - Jader Assis
 *
 */
public class EnderecoDao {

	@Inject
	private EntityManager em;
	
	public void salvar(Endereco endereco) {
		em.persist(endereco);
	}
}
