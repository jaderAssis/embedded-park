package br.com.embedded.park.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.jboss.seam.faces.validation.InputField;

@FacesValidator("finalizarLocacaoValidator")
public class FinalizarLocacaoValidator extends AbstractValidator {

	@Inject @InputField
	private String cartao;
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
			
		if ( isEmpty(cartao) ) {
			addMsgError("locacao_erroPlaca");
		}
	}
	
}