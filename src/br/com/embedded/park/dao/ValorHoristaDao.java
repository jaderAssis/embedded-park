package br.com.embedded.park.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.embedded.park.entity.ValorHorista;

public class ValorHoristaDao {

	@Inject
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public ValorHorista find() {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select valorHorista from ValorHorista valorHorista ");
		Query query = em.createQuery(jpql.toString());
		
		List<ValorHorista> listValor = query.getResultList(); 
		
		if ( !listValor.isEmpty() ) {
			return listValor.get(0);
		}
		else {
			return null;
		}
	}
	
	public void saveOrUpdate(ValorHorista valorHorista) {
		em.merge(valorHorista);
	}
	
}
