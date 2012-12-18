package br.com.embedded.park.controller;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.embedded.park.exception.BusinessException;
import br.com.embedded.park.service.LocacaoService;
import br.com.embedded.park.service.PagamentoService;

/**
 * 
 * @author - Jader Assis
 *
 */
@Named
@ViewScoped
public class PagamentoController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private LocacaoService locacaoService;
	@Inject
	private PagamentoService pagamentoService;
	private String descricaoCartao;
	private BigDecimal valorAPagar;
	
	public void valorAPagar(ActionEvent event) {
		try {
			
			if ( valorAPagar != null) {
				msgValorAPagar("O Pagamento dessa locacao ja foi realizado com o valor de:");
				return;
			}
			
			valorAPagar = pagamentoService.valorAPagar(descricaoCartao);
			
			msgValorAPagar("Valor a pagar: ");
		} 
		catch (BusinessException e) {
			addMessageErro(e.getMessage());
		}
		
		limpaForm();
	}

	private void limpaForm() {
		descricaoCartao = null;
		valorAPagar = null;
	}
	
	private void msgValorAPagar(String msg) {
		getFacesContext().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg + this.valorAPagar , null));
		setaMsgParaEscopoFlash();
	}
	
	
	public String getDescricaoCartao() {
		return descricaoCartao;
	}

	public void setDescricaoCartao(String descricaoCartao) {
		this.descricaoCartao = descricaoCartao;
	}


	public BigDecimal getValorAPagar() {
		return valorAPagar;
	}


	public void setValorAPagar(BigDecimal valorAPagar) {
		this.valorAPagar = valorAPagar;
	}
	
}
