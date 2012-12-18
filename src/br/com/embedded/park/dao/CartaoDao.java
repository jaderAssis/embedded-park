package br.com.embedded.park.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.embedded.park.entity.Cartao;

public class CartaoDao {

	@Inject
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Cartao> findAllCartoesLiberados() {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select cartao from Cartao cartao ");
		jpql.append(" where cartao.dataFimVigencia is null ");
		jpql.append(" and cartao.id not in ");
		jpql.append(" ( select mensalista.cartao.id from Mensalista mensalista ");
		jpql.append(" inner join mensalista.cartao ) ");
		
		Query query = em.createQuery(jpql.toString());
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cartao> findAll() {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select cartao from Cartao cartao ");
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}
	
	public Cartao findById(Long id){
		return em.find(Cartao.class, id);
	}
	
	public Cartao findByCodigo(String codigo) {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select cartao from Cartao cartao ");
		jpql.append(" where cartao.codigo = :codigo ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("codigo", codigo);
		
		return (Cartao) query.getSingleResult(); 
	}
	
	public boolean existeCartao(String codigo) {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select cartao from Cartao cartao ");
		jpql.append(" where cartao.codigo = :codigo ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("codigo", codigo);
		try {
			query.getSingleResult();
			return true;
		}catch(NoResultException e) {
			return false;
		}
	}
	
}
