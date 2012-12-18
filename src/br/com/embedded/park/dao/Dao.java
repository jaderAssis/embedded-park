package br.com.embedded.park.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public abstract class Dao<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private final Class<T> classe;
	
	@Inject
	private EntityManager em;
	
	protected Dao(Class<T> classe) {
		this.classe = classe;
	}

	protected void adiciona(T t) {
		em.persist(t);
	}
	
	protected void remove(T t) {
		em.remove(em.merge(t));
	}

	protected void atualiza(T t) {
		em.merge(t);
	}

	protected List<T> listaTodos() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		return em.createQuery(query).getResultList();
	}
	
	protected T findById(Long id) {
		T instancia = em.find(classe, id);
		return instancia;
	}
	
	protected int contaTodos() {
		long result = (Long) em.createQuery("select count(n) from " + classe.getCanonicalName() + " n")
				.getSingleResult();
		
		return (int) result;
	}

	@SuppressWarnings("unchecked")
	protected List<T> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		Query q = em.createQuery(query);
		q.setFirstResult(firstResult);
		q.setMaxResults(maxResults);

		return q.getResultList();
	}
}
