package br.com.embedded.park.service;

import java.io.Serializable;
import java.util.List;

import br.com.embedded.park.entity.Cartao;
import br.com.embedded.park.entity.Documento;
import br.com.embedded.park.entity.Mensalista;
import br.com.embedded.park.exception.BusinessException;

/**
 * 
 * @author - Jader Assis
 *
 */
public interface MensalistaService extends Serializable {

	void cadastrarMensalista(Mensalista mensalista, Long idCartao, Long idUf, List<Documento> listaDocumentos) 
		throws BusinessException;
	
	Mensalista findByCartao(Cartao cartao);
	
}
