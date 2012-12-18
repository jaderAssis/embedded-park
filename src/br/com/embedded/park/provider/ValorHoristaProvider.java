package br.com.embedded.park.provider;

import javax.inject.Inject;

import br.com.embedded.park.annotation.Transactional;
import br.com.embedded.park.dao.ValorHoristaDao;
import br.com.embedded.park.entity.ValorHorista;
import br.com.embedded.park.service.ValorHoristaService;

/**
 * 
 * @author - Jader Assis
 *
 */
public class ValorHoristaProvider implements ValorHoristaService {

	private static final long serialVersionUID = 1L;

	@Inject
	private ValorHoristaDao valorHoristaDao;
	
	@Override
	public ValorHorista find() {
		return valorHoristaDao.find();
	}

	@Override
	@Transactional
	public void saveOrUpdate(ValorHorista valorHorista) {
		ValorHorista valor = valorHoristaDao.find();
		ValorHorista valorHora = valorHorista;
		
		if ( valor != null  ) {
			valorHora = valor;
		}
		valorHora.setValor(valorHorista.getValor());
		valorHoristaDao.saveOrUpdate(valorHora);
	}
	
}
