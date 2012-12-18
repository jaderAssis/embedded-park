package br.com.embedded.park.dao;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.embedded.park.entity.Locacao;
import br.com.embedded.park.exception.BusinessException;

/**
 * 
 * @author - Jader Assis
 *
 */
public class LocacaoDao {

	@Inject
	private EntityManager em;
	
	public void save(Locacao locacao) {
		em.persist(locacao);
	}
	
	public void update(Locacao locacao) {
		em.merge(locacao);
	}
	
	@SuppressWarnings("unchecked")
	public List<Locacao> findLocacoesAPagar() {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select locacao from Locacao locacao ");
		jpql.append(" left join fetch locacao.mensalista ");
		jpql.append(" where locacao.dataFim is not null ");
		jpql.append(" and locacao.mensalista.id not in ");
		jpql.append(" ( select mensalista from Mensalista mensalista ");
		jpql.append(" where mensalista.dataFimVigencia is not null ");
		jpql.append(" and mensalista.dataFimVigencia <= :dataAtual ) ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("dataAtual", new Date());
		
		return query.getResultList();
	}
	
	public Locacao findLocacaoByCartao(String descricaoCartao) throws BusinessException {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select locacao from Locacao locacao ");
		jpql.append(" left join locacao.cartao cartao ");
		jpql.append(" left join fetch locacao.mensalista mensalista ");
		jpql.append(" where locacao.cartao.descricao = :descricao ");
		jpql.append(" and locacao.dataInicio is not null ");
		jpql.append(" and locacao.dataFim is null ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("descricao", descricaoCartao);
		
		try {
			return (Locacao) query.getSingleResult();		
		}
		catch (NoResultException e) {
			throw new BusinessException("locacao_ja_finalizada");
		}
	}

}