package br.com.embedded.park.provider;

import java.math.BigDecimal;
import java.util.Date;

import javax.inject.Inject;

import br.com.embedded.park.annotation.Transactional;
import br.com.embedded.park.dao.LocacaoDao;
import br.com.embedded.park.dao.PagamentoDao;
import br.com.embedded.park.entity.Locacao;
import br.com.embedded.park.entity.Pagamento;
import br.com.embedded.park.entity.ValorHorista;
import br.com.embedded.park.exception.BusinessException;
import br.com.embedded.park.service.PagamentoService;

/**
 * 
 * @author - Jader Assis
 *
 */
public class PagamentoProvider implements PagamentoService {

	private static final long serialVersionUID = 1L;

	@Inject
	private LocacaoDao locacaoDao;
	@Inject
	private ValorHoristaProvider valorHoristaProvider;
	@Inject
	private PagamentoDao pagamentoDao;
	
	private BigDecimal valorPadrao = new BigDecimal("10.00");
	
	@Override
	@Transactional
	public BigDecimal valorAPagar(String descricaoCartao) throws BusinessException {
		descricaoCartao = descricaoCartao.toUpperCase();
		Locacao locacaoAPagar = locacaoDao.findLocacaoByCartao(descricaoCartao);
		ValorHorista valorHora = valorHoristaProvider.find();
		
		//locacao realizar por mensalista
		if ( locacaoAPagar.getMensalista() != null ) {
			throw new BusinessException("pagamento_locacao_mensalista");
		}
		
		BigDecimal valor;
		if ( valorHora == null || valorHora.getValor() == null ) {
			valor = valorPadrao;
		} else {
			valor = valorHora.getValor();
		}
		long horasLocados = new Date().getTime() - locacaoAPagar.getDataInicio().getTime();
		long horaEmMilisegundos = 3600000;
		double qtdHora = horasLocados / horaEmMilisegundos;
		if ( qtdHora < 1 ) {
			qtdHora = 1;
		}
		
		valor = valor.multiply(new BigDecimal(qtdHora));
		
		Pagamento pagamento = new Pagamento();
		pagamento.setData(new Date());
		pagamento.setLocacao(locacaoAPagar);
		pagamento.setTipoPagamento("Dinheiro");
		pagamento.setValor(valor);
		save(pagamento);
		
		return valor;
	}

	public void save(Pagamento pagamento) {
		pagamentoDao.save(pagamento);
	}
	
}
