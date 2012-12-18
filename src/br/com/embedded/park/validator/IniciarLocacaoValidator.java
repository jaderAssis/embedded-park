package br.com.embedded.park.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.jboss.seam.faces.validation.InputField;

@FacesValidator("iniciarLocacaoValidator")
public class IniciarLocacaoValidator extends AbstractValidator {

	@Inject @InputField
	private String placa;
	
	@Inject @InputField
	private String modelo;
	
	@Inject @InputField
	private String idCartao;
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
			
		if ( isEmpty(placa) ) {
			addMsgError("locacao_erroPlaca");
		}
		if ( isEmpty(modelo) ) {
			addMsgError("locacao_erroModelo");
		}
		if ( isEmpty(idCartao) ) {
			addMsgError("locacao_erroCartao");
		}
	}
	
}