package br.com.embedded.park.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.embedded.park.entity.Cartao;
import br.com.embedded.park.entity.Veiculo;
import br.com.embedded.park.service.CartaoService;
import br.com.embedded.park.service.LocacaoService;

/**
 * 
 * @author - Jader Assis
 *
 */
@Named
@ViewScoped
public class IniciarLocacaoController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private LocacaoService locacaoService;
	@Inject
	private CartaoService cartaoService;
	
	//variaveis web
	private Veiculo veiculo;
	private Long idCartao;
	private List<Cartao> listAllCartoes;
	
	@PostConstruct
	public void initialize() {
		veiculo = new Veiculo();
		listAllCartoes = cartaoService.findAllCartoesLiberados();
	}
	
	public String iniciarLocacao() {
		try {
			locacaoService.iniciarLocacao(veiculo, idCartao);
			
			addMessageCadastroSucesso();
		}
		catch(Exception e) {
			addMessageErroGenerico(e.getMessage());
			return "";
		}
		
		return "/locacao/index?faces-redirect=true";
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Long getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(Long idCartao) {
		this.idCartao = idCartao;
	}

	public List<Cartao> getListAllCartoes() {
		return listAllCartoes;
	}

	public void setListAllCartoes(List<Cartao> listAllCartoes) {
		this.listAllCartoes = listAllCartoes;
	}
	

}
