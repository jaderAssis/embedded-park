package br.com.embedded.park.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.embedded.park.entity.Usuario;

public class UsuarioDao {

	@Inject
	private EntityManager em;

	/**
	 * Verifica se usuario exite no banco
	 *  
	 * @author Jader Assis
	 * @since 28/07/2012 08:41:21
	 *
	 * @param usuario
	 * @return null se usuario nao existir na base de dados
	 */
	public Usuario existe(Usuario usuario) {
		try {
			StringBuilder jpql = new StringBuilder();
			jpql.append("select usuario from Usuario usuario ");
			jpql.append(" inner join fetch usuario.grupos grupos ");
			jpql.append(" where usuario.login = :login and usuario.senha = :senha");
			
			Query query = em.createQuery(jpql.toString());
			query.setParameter("login", usuario.getLogin());
			query.setParameter("senha", usuario.getSenha());
			
			return (Usuario) query.getSingleResult();
		}
		catch (NoResultException e) {
			return null;
		}
	}
	
}