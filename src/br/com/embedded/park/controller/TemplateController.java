package br.com.embedded.park.controller;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.embedded.park.service.VagaService;
import br.com.embedded.park.to.VagaTo;

/**
 * 
 * @author Jader Assis
 *
 */
@Named
public class TemplateController extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private VagaService vagaService;
	
	private VagaTo vaga;
	
	@PostConstruct
	public void initialize() {
		vaga = vagaService.findDadosVagas();
	}

	public VagaTo getVaga() {
		return vaga;
	}

	public void setVaga(VagaTo vaga) {
		this.vaga = vaga;
	}

}
