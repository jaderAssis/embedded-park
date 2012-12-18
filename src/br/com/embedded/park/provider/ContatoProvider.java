package br.com.embedded.park.provider;

import javax.inject.Inject;

import br.com.embedded.park.dao.ContatoDao;
import br.com.embedded.park.entity.Contato;
import br.com.embedded.park.service.ContatoService;

/**
 * 
 * @author - Jader Assis
 *
 */
public class ContatoProvider implements ContatoService {

	private static final long serialVersionUID = 1L;

	@Inject
	private ContatoDao contatoDao;
	
	public void salvar(Contato contato) {
		contatoDao.salvar(contato);
	}
}
