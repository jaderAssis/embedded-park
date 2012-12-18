package br.com.embedded.park.provider;

import javax.inject.Inject;

import br.com.embedded.park.dao.VeiculoDao;
import br.com.embedded.park.entity.Veiculo;
import br.com.embedded.park.service.VeiculoService;

/**
 * 
 * @author - Jader Assis
 *
 */
public class VeiculoProvider implements VeiculoService {

	private static final long serialVersionUID = 1L;

	@Inject
	private VeiculoDao veiculoDao;
	
	
	@Override
	public void save(Veiculo veiculo) {
		veiculoDao.save(veiculo);
	}
}
