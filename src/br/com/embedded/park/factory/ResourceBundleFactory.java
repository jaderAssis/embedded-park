package br.com.embedded.park.factory;

import java.util.ResourceBundle;

import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

public class ResourceBundleFactory {

	@Inject       
	private FacesContext facesContext;

	@Produces
	public ResourceBundle getResourceBundle() {
		return ResourceBundle.getBundle("/br/com/embedded/park/message/messages", facesContext.getViewRoot().getLocale());
	}

}
