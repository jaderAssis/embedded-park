package br.com.embedded.park.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.embedded.park.entity.ValorMensalista;

/**
 * 
 * @author - Jader Assis
 *
 */
public class ValorMensalistaDao {

	@Inject
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<ValorMensalista> findAll() {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select valorMensalista from ValorMensalista ValorMensalista");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}
	
	public void saveOrUpdate(ValorMensalista valorMensalista) {
		em.merge(valorMensalista);
	}
}
