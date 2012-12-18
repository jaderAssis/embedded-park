package br.com.embedded.park.service;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.embedded.park.entity.Pagamento;
import br.com.embedded.park.exception.BusinessException;

/**
 * 
 * @author - Jader Assis
 *
 */
public interface PagamentoService extends Serializable {

	BigDecimal valorAPagar(String descricaoCartao) throws BusinessException;
	
	void save(Pagamento pagamento);
	
}
