package br.com.embedded.park.service;

import java.io.Serializable;

import br.com.embedded.park.entity.Locacao;
import br.com.embedded.park.entity.Veiculo;
import br.com.embedded.park.exception.BusinessException;

/**
 * 
 * @author - Jader Assis
 *
 */
public interface LocacaoService extends Serializable {

	void iniciarLocacao(Veiculo veiculo, Long idCartao);
	
	void finalizarLocacao(Locacao locacao);
	
	Locacao finalizarLocacao(String codigoCartao) throws BusinessException;
	
	
}
