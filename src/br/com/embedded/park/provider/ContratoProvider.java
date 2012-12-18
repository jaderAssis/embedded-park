package br.com.embedded.park.provider;

import java.util.Date;

import javax.inject.Inject;

import br.com.embedded.park.dao.ContratoDao;
import br.com.embedded.park.entity.Contrato;
import br.com.embedded.park.service.ContratoService;

/**
 * 
 * @author - Jader Assis
 *
 */
public class ContratoProvider implements ContratoService {

	private static final long serialVersionUID = 1L;

	@Inject
	private ContratoDao contratoDao;
	
	@Override
	public void salvar(Contrato contrato) {
		contrato.setDataContrato(new Date());
		contratoDao.salvar(contrato);
	}

	
}
