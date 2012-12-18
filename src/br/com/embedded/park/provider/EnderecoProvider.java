package br.com.embedded.park.provider;

import javax.inject.Inject;

import br.com.embedded.park.dao.EnderecoDao;
import br.com.embedded.park.entity.Endereco;
import br.com.embedded.park.service.EnderecoService;

/**
 * 
 * @author - Jader Assis
 *
 */
public class EnderecoProvider implements EnderecoService {

	private static final long serialVersionUID = 1L;

	@Inject
	private EnderecoDao enderecoDao;
	
	@Override
	public void salvar(Endereco endereco) {
		enderecoDao.salvar(endereco);
	}

}
