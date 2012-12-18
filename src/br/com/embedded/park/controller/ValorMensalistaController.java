package br.com.embedded.park.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.embedded.park.entity.ValorMensalista;
import br.com.embedded.park.enuns.TipoAutomovel;
import br.com.embedded.park.service.ValorMensalistaService;

/**
 * 
 * @author - Jader Assis
 *
 */
@Named
@ViewScoped
public class ValorMensalistaController extends BaseController {

	private static final long serialVersionUID = 1L;

	@Inject
	private ValorMensalistaService valorMensalistaService;
	
	private String valor;
	private String tipoAutomovel;
	private List<TipoAutomovel> listTipoAutomovel;
	
	@PostConstruct
	public void initialize() {
		initTipoAutomovel();
	}
	
	public String cadastrar() {
		ValorMensalista valorMensalista = new ValorMensalista();
		valor = valor.replaceAll(",", ".");
		valorMensalista.setValor(new BigDecimal(valor));
		
		valorMensalistaService.saveOrUpdate(valorMensalista);

		addMessageCadastroSucesso();
		
		return "/administrar/inicio?faces-redirect=true";
	}
	
	
	private void initTipoAutomovel() {
		if ( listTipoAutomovel == null ) {
			listTipoAutomovel = new ArrayList<TipoAutomovel>(); 
			for (TipoAutomovel tipo : TipoAutomovel.values()) {
				listTipoAutomovel.add(tipo);
			}
		}
	}

	public List<TipoAutomovel> getListTipoAutomovel() {
		return listTipoAutomovel;
	}

	public void setListTipoAutomovel(List<TipoAutomovel> listTipoAutomovel) {
		this.listTipoAutomovel = listTipoAutomovel;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getTipoAutomovel() {
		return tipoAutomovel;
	}

	public void setTipoAutomovel(String tipoAutomovel) {
		this.tipoAutomovel = tipoAutomovel;
	}

}
