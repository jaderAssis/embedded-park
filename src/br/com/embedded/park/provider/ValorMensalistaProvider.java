package br.com.embedded.park.provider;

import java.util.List;

import javax.inject.Inject;

import br.com.embedded.park.annotation.Transactional;
import br.com.embedded.park.dao.ValorMensalistaDao;
import br.com.embedded.park.entity.ValorMensalista;
import br.com.embedded.park.service.ValorMensalistaService;

/**
 * 
 * @author - Jader Assis
 *
 */
public class ValorMensalistaProvider implements ValorMensalistaService {

	private static final long serialVersionUID = 1L;

	@Inject
	private ValorMensalistaDao valorMensalistaDao;
	
	@Override
	public List<ValorMensalista> findAll() {
		return valorMensalistaDao.findAll();
	}

	@Override
	@Transactional
	public void saveOrUpdate(ValorMensalista valorMensalista) {
		List<ValorMensalista> list = valorMensalistaDao.findAll();
		ValorMensalista valor = valorMensalista;
		
		if ( list != null && !list.isEmpty() ) {
			valor = list.get(0);
		}
		valor.setValor(valorMensalista.getValor());
		valorMensalistaDao.saveOrUpdate(valor);
		
	}

}
