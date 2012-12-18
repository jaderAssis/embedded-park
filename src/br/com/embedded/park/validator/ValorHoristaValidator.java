package br.com.embedded.park.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.jboss.seam.faces.validation.InputField;

@FacesValidator("valorHoristaValidator")
public class ValorHoristaValidator extends AbstractValidator {

	@Inject @InputField
	private String valor;

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
			
		if ( isEmpty(valor) || !valor.matches("^(?=[^A-Za-z]+$).*[0-9].*$") ) {
			addMsgError("valorHorista_valorErro");
		}
	}
}