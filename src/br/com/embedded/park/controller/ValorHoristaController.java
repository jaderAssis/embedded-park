package br.com.embedded.park.controller;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.embedded.park.entity.ValorHorista;
import br.com.embedded.park.service.ValorHoristaService;

/**
 * 
 * @author - Jader Assis
 *
 */
@Named
@ViewScoped
public class ValorHoristaController extends BaseController {

	private static final long serialVersionUID = 1L;

	@Inject
	private ValorHoristaService valorHoristaService;
	
	private String valor;
	
	@PostConstruct
	public void initialize() {
		
	}
	
	public String cadastrar() {
		try {
			ValorHorista valorHorista = new ValorHorista();
			valor = valor.replaceAll(",", ".");
			valorHorista.setValor(new BigDecimal(valor));
			
			valorHoristaService.saveOrUpdate(valorHorista);
			
			addMessageCadastroSucesso();
		}
		catch (Exception e) {
			
		}
		return "/administrar/inicio?faces-redirect=true";
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}