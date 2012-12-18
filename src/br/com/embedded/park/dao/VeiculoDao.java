package br.com.embedded.park.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.embedded.park.entity.Veiculo;

/**
 * 
 * @author - Jader Assis
 *
 */
public class VeiculoDao {

	@Inject
	private EntityManager em;
	
	public void save(Veiculo veiculo) {
		em.persist(veiculo);
	}
}
