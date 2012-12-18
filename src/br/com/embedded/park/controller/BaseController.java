package br.com.embedded.park.controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 * Controller pai da app
 * 
 * @author - Jader Assis
 *
 */
public abstract class BaseController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject       
	private transient FacesContext facesContext;
	@Inject
	private transient ResourceBundle bundle;
	
	private String textoRecepcao;
	private Date dataAtual;

	@PostConstruct
	public void initialize() {
		dataAtual = Calendar.getInstance().getTime();
	}
	
	public Date getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}

	public String getTextoRecepcao() {
		return textoRecepcao;
	}

	public void setTextoRecepcao(String textoRecepcao) {
		this.textoRecepcao = textoRecepcao;
	}

	protected boolean isEmpty(String texto) {
		if ( texto == null || "".equals(texto) ) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @author Jader Assis
	 * @since 16/09/2012 10:12:07
	 *
	 * @param textoTela
	 */
	protected void addMessageCadastroSucesso() {
		getFacesContext().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("cadastro_sucesso"), null));
		
		setaMsgParaEscopoFlash();
	}
	
	/**
	 * Exibe mensagem na tela
	 * 
	 * @param severity
	 * @param textoTela
	 * @param details
	 */
	protected void addMessageInfo(String textoTela) {
		
		getFacesContext().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString(textoTela), null));
		
		setaMsgParaEscopoFlash();
	}
	
	/**
	 * 
	 * @author Jader Assis
	 * @since 16/09/2012 10:25:52
	 *
	 * @param textoTela
	 */
	protected void addMessageErro(String textoTela) {
		getFacesContext().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString(textoTela), null));
		
		setaMsgParaEscopoFlash();
	}
	
	/**
	 * Exibe mensagem na tela para execoes genericas
	 * 
	 * @param textoTela
	 */
	protected void addMessageErroGenerico(String textoTela) {
		getFacesContext().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, textoTela, null));
		
		setaMsgParaEscopoFlash();
	}
	
	public FacesContext getFacesContext() {
		return facesContext;
	}
	
	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	protected ResourceBundle getBundle() {
		return bundle;
	}

	/**
	 *  Coloca o msg do jsf em escopo flash para nao sumir da tela
	 *  
	 *  @author jader 
	 */
	protected void setaMsgParaEscopoFlash() {
		FacesContext.getCurrentInstance()
			.getExternalContext().getFlash().setKeepMessages(true);
	}


}
