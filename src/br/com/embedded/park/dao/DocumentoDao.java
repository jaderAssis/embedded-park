package br.com.embedded.park.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.embedded.park.entity.Documento;

/**
 * 
 * @author - Jader Assis
 *
 */
public class DocumentoDao {

	@Inject
	private EntityManager em;
	
	public void salvar(Documento documento) {
		em.persist(documento);
	}
}
