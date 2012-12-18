package br.com.embedded.park.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.embedded.park.entity.Pagamento;

/**
 * 
 * @author - Jader Assis
 *
 */
public class PagamentoDao {
	
	@Inject
	private EntityManager em;

	public void save(Pagamento pagamento) {
		em.persist(pagamento);
	}
	
}
