package br.com.embedded.park.controller;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import br.com.embedded.park.entity.PontoEletronico;
import br.com.embedded.park.exception.BusinessException;
import br.com.embedded.park.service.PontoEletronicoService;

/**
 * 
 * @author - Jader Assis
 *
 */
@Named
public class PontoEletronicoController extends BaseController {

	private static final long serialVersionUID = 1L;

	@Inject
	private transient UsuarioLogadoController usuarioLogado;
	@Inject
	private transient PontoEletronicoService pontoEletronicoService;
	
	private LazyDataModel<PontoEletronico> dataModel;
	
	@PostConstruct
	public void initialize() {
		dataModel = pontoEletronicoService.getPaginador(
				usuarioLogado.getUsuario());
	}
	
	public void marcarPontoEletronico() {
		try {
			pontoEletronicoService.marcarPontoParaUsuario(usuarioLogado.getUsuario());
			addMessageInfo("pontoEletronico_sucesso");
		}
		catch (BusinessException e) {
			addMessageErro(e.getMessage());
		}
		catch (Exception e) {
			addMessageErroGenerico(e.getMessage());
		}
	}

	public LazyDataModel<PontoEletronico> getDataModel() {
		return dataModel;
	}

	public void setDataModel(LazyDataModel<PontoEletronico> dataModel) {
		this.dataModel = dataModel;
	}
	
}
