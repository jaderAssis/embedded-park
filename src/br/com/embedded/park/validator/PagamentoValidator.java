package br.com.embedded.park.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.jboss.seam.faces.validation.InputField;

@FacesValidator("pagamentoValidator")
public class PagamentoValidator extends AbstractValidator {

	@Inject @InputField
	private String descricaoCartao;
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
			
		if ( isEmpty(descricaoCartao) ) {
			addMsgError("locacao_erroPlaca");
		}
	}
	
}