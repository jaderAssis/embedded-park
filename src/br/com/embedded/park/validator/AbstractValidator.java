package br.com.embedded.park.validator;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

/**
 * 
 * @author - Jader Assis
 *
 */
public abstract class AbstractValidator implements Validator {

	@Inject
	private transient ResourceBundle bundle;
	
	protected boolean isEmpty(String texto) {
		if (texto == null || "".equals(texto)) {
			return true;
		}
		return false;
	}

	protected void addMsgError(String msg) {
		throw new ValidatorException(
				new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					bundle.getString(msg.trim()), null));
	}
	
}
