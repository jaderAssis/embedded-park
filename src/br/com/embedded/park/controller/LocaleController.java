package br.com.embedded.park.controller;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Classe responsavel pelo internacionalizacao da app
 * 
 * @author - Jader Assis
 *
 */
@Named
@SessionScoped
public class LocaleController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Locale currentLocale = new Locale("pt", "BR");

	@Inject
	private FacesContext context;
	
	
	public void englishLocale() {
		currentLocale = Locale.US;
		context.getViewRoot().setLocale(currentLocale);
	}

	public void portugueseLocale() {
		currentLocale = new Locale("pt", "BR");
		context.getViewRoot().setLocale(currentLocale);
	}

	public Locale getCurrentLocale() {
		return currentLocale;
	}
}