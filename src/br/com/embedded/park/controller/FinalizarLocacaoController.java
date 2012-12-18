package br.com.embedded.park.controller;


import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.embedded.park.exception.BusinessException;
import br.com.embedded.park.service.LocacaoService;

/**
 * 
 * @author - Jader Assis
 *
 */
@Named
@RequestScoped
public class FinalizarLocacaoController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private LocacaoService locacaoService;
	private String codigoCartao;
	
	public void finalizarLocacao(ActionEvent event) {
		try {
			locacaoService.finalizarLocacao(codigoCartao);
			
			addMessageInfo("locacao_finalizada");
			
			codigoCartao = null;
		} 
		catch (BusinessException e) {
			addMessageErro(e.getMessage());
		}
	}
	
	public String getCartao() {
		return codigoCartao;
	}

	public void setCartao(String cartao) {
		this.codigoCartao= cartao;
	}
}
