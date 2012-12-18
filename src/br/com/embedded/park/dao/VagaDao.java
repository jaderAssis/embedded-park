package br.com.embedded.park.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.embedded.park.to.VagaTo;

/**
 * 
 * @author Jader Assis
 *
 */
public class VagaDao {

	@Inject
	private EntityManager em;
	
	
	public VagaTo findDadosVagas() {
		StringBuilder jpql =  new StringBuilder();
		
		jpql.append("select count(vaga.id), ");
		jpql.append("(select count(vaga.ocupada) from Vaga vaga where vaga.ocupada = :ocupada) ");
		jpql.append("from Vaga vaga");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("ocupada", true);
		
		Object[] result = (Object[]) query.getSingleResult();;
		
		VagaTo vagaTo = new VagaTo();
		vagaTo.setTotalVagas((Long)result[0]);
		vagaTo.setVagasOcupadas((Long)result[1]);
		
		return vagaTo;
	}
}
