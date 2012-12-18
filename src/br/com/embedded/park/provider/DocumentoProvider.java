package br.com.embedded.park.provider;

import br.com.embedded.park.dao.DocumentoDao;
import br.com.embedded.park.entity.Documento;
import br.com.embedded.park.service.DocumentoService;

/**
 * 
 * @author - Jader Assis
 *
 */
public class DocumentoProvider implements DocumentoService {

	private static final long serialVersionUID = 1L;

	private DocumentoDao documentoDao;
	
	@Override
	public void salvar(Documento documento) {
		documentoDao.salvar(documento);
	}
}
