package br.com.embedded.park.dao;

import java.util.List;

import br.com.embedded.park.entity.Usuario;

/**
 * 
 * @author - Jader Assis
 *
 */
public interface DaoPaginacao {

	List<?> listaPaginada(int firstResult, int maxResults, Usuario usuario);
	
	long contaTodos(Usuario usuario);
}
