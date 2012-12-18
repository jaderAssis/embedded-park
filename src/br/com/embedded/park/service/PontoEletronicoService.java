package br.com.embedded.park.service;

import org.primefaces.model.LazyDataModel;

import br.com.embedded.park.entity.PontoEletronico;
import br.com.embedded.park.entity.Usuario;
import br.com.embedded.park.exception.BusinessException;

/**
 * 
 * @author - Jader Assis
 *
 */
public interface PontoEletronicoService {

	/**
	 * 
	 * @author Jader Assis
	 * @since 05/08/2012 12:26:20
	 *
	 * @param usuario
	 */
	void marcarPontoParaUsuario(Usuario usuario) throws BusinessException;
	
	
	LazyDataModel<PontoEletronico> getPaginador(Usuario Usuario);
}
