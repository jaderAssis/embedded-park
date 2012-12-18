package br.com.embedded.park.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.embedded.park.entity.Cartao;
import br.com.embedded.park.entity.Mensalista;

/**
 * 
 * @author Jader Assis
 *
 */
public class MensalistaDao {

	@Inject
	private EntityManager em;
	
	public Long salvar(Mensalista mensalista) {
		em.persist(mensalista);
		
		return mensalista.getId();
	}
	
	public Mensalista findByCartao(Cartao cartao) {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select mensalista from Mensalista mensalista ");
		jpql.append(" where mensalista.cartao = :cartao ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("cartao", cartao);
		
		Mensalista mensalista = null;
		try {
			mensalista = (Mensalista) query.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
		return mensalista;
	}
	
}
