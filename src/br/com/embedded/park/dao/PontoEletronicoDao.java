package br.com.embedded.park.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.embedded.park.entity.PontoEletronico;
import br.com.embedded.park.entity.Usuario;

public class PontoEletronicoDao implements DaoPaginacao {

	@Inject
	private EntityManager em;
	

	public void saveOrUpdate(PontoEletronico pontoEletronico) {
		if (pontoEletronico.getId() == null) {
			em.persist(pontoEletronico);
		}
		else {
			em.merge(pontoEletronico);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<PontoEletronico> listPontosDoUsuario(Usuario usuario, int maxResult) {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select ponto from PontoEletronico ponto ");
		jpql.append(" where ponto.usuario = :usuario ");
		jpql.append(" order by dataEntrada desc");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("usuario", usuario);
		query.setMaxResults(maxResult);
		
		return query.getResultList();
	}

	
	@Override
	public List<?> listaPaginada(int firstResult, int maxResults, Usuario usuario) {
			
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select ponto from PontoEletronico ponto ");
		jpql.append(" where ponto.usuario =:usuario ");
		jpql.append(" order by ponto.dataEntrada desc ");
		
		Query query = em.createQuery(jpql.toString());
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		query.setParameter("usuario", usuario);
		
		return query.getResultList();
	}
	
	@Override
	public long contaTodos(Usuario usuario) {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select count(ponto.id) from PontoEletronico ponto ");
		jpql.append(" where ponto.usuario = :usuario");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("usuario", usuario);
		
		return (Long) query.getSingleResult();
	}
	
}