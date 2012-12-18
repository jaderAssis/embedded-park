package br.com.embedded.park.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.embedded.park.entity.Uf;

/**
 * 
 * @author - Jader Assis
 *
 */
public class UfDao {

	@Inject
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Uf> findAll() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select uf from Uf uf");
		jpql.append(" order by uf.descricao ");
		
		Query query = em.createQuery(jpql.toString());
		
		return query.getResultList();
	}
	
	public Uf findById(Long id) {
		return em.find(Uf.class, id);
	}
}
