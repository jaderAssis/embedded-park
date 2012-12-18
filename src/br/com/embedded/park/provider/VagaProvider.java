package br.com.embedded.park.provider;

import javax.inject.Inject;

import br.com.embedded.park.dao.VagaDao;
import br.com.embedded.park.service.VagaService;
import br.com.embedded.park.to.VagaTo;

/**
 * 
 * @author Jader Assis
 *
 */
public class VagaProvider implements VagaService {

	private static final long serialVersionUID = 1L;

	@Inject
	private VagaDao vagaDao;
	
	public VagaTo findDadosVagas() {
		return vagaDao.findDadosVagas();
	}
	
}
