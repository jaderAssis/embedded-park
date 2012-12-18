package br.com.embedded.park.provider;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.embedded.park.annotation.Transactional;
import br.com.embedded.park.dao.CartaoDao;
import br.com.embedded.park.dao.LocacaoDao;
import br.com.embedded.park.entity.Cartao;
import br.com.embedded.park.entity.Locacao;
import br.com.embedded.park.entity.Mensalista;
import br.com.embedded.park.entity.Veiculo;
import br.com.embedded.park.exception.BusinessException;
import br.com.embedded.park.service.CartaoService;
import br.com.embedded.park.service.LocacaoService;
import br.com.embedded.park.service.MensalistaService;
import br.com.embedded.park.service.VeiculoService;

/**
 * 
 * @author - Jader Assis
 *
 */
public class LocacaoProvider implements LocacaoService {

	private static final long serialVersionUID = 1L;

	@Inject
	private CartaoService cartaoService;
	@Inject
	private MensalistaService mensalistaService;
	@Inject
	private LocacaoDao locacaoDao;
	@Inject
	private VeiculoService veiculoService;
	@Inject
	private CartaoDao cartaoDao;
	
	@Override
	@Transactional
	public void iniciarLocacao(Veiculo veiculo, Long idCartao) {
		Locacao locacao = new Locacao();
		locacao.setDataInicio(new Date());
		locacao.setVeiculo(veiculo);
		
		Cartao cartao =  cartaoService.findById(idCartao);
		Mensalista mensalista = mensalistaService.findByCartao(cartao); 
		locacao.setMensalista(mensalista);
		locacao.setCartao(cartao);
		
		veiculoService.save(veiculo);
		locacaoDao.save(locacao);
		
	}
	
	public void finalizarLocacao(Locacao locacao) {
		locacao.setDataFim(new Date());
		
	}
	
	@Override
	@Transactional
	public Locacao finalizarLocacao(String descricaoCartao) throws BusinessException {
		descricaoCartao = descricaoCartao.toUpperCase();
		Locacao locacao = locacaoDao.findLocacaoByCartao(descricaoCartao);
		
		if ( locacao == null ) {
			return null;
		}
		
		//se a locacao foi feita por um mensalista retorna msg
		if ( locacao.getMensalista() != null ) {
			throw new BusinessException("locacao_pagamento_mensalista");
		}
		
		locacao.setDataFim(new Date());
		locacaoDao.update(locacao);
		
		return locacao;
	}
	
	public List<Locacao> findLocacoesAPagar() {
		return locacaoDao.findLocacoesAPagar();
	}
}
