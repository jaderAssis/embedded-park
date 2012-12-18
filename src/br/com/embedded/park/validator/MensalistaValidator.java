package br.com.embedded.park.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.jboss.seam.faces.validation.InputField;

@FacesValidator("mensalistaValidador")
public class MensalistaValidator extends AbstractValidator {

	@Inject @InputField
	private String nome;
	@Inject @InputField
	private String dataFimVigencia;
	@Inject @InputField
	private String tipoEndereco;
	@Inject @InputField
	private String enderecoDescricao;
	@Inject @InputField
	private String enderecoNumero;
	@Inject @InputField
	private String idUf;
	@Inject @InputField
	private String email;
	@Inject @InputField
	private String telResidencial;
	@Inject @InputField
	private String telCelular;
	@Inject @InputField
	private String telComercial;
	@Inject @InputField
	private String vencMensal;
	@Inject @InputField
	private String valor;
	@Inject @InputField
	private String idCartao;
	@Inject @InputField
	private String rg;
	@Inject @InputField
	private String cpf;
	@Inject @InputField
	private String cnpj;
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
			
		if( isEmpty(nome) ) {
			addMsgError("cadastrarMesalista_erroNome");
		}
		if ( isEmpty(dataFimVigencia) ) {
			addMsgError("cadastrarMesalista_erroDataFimVigencia");
		}
		if ( isEmpty(tipoEndereco) ) {
			addMsgError("cadastrarMesalista_erroTipoEndereco");
		}
		if ( isEmpty(enderecoDescricao) ) {
			addMsgError("cadastrarMesalista_erroDescricaoEndereco");
		}
		if ( isEmpty(enderecoNumero) ){
			addMsgError("cadastrarMesalista_erroNumero");
		}
		if ( isEmpty(idUf) ) {
			addMsgError("cadastrarMesalista_erroUf");
		}
		if ( isEmpty(email) ) {
			addMsgError("cadastrarMesalista_erroEmail");
		}
		if ( isEmpty(vencMensal) ) {
			addMsgError("cadastrarMesalista_erroDiaMensal");
		}
		if ( isEmpty(valor) ) {
			addMsgError("cadastrarMesalista_erroValorMensal");
		}
		else if( !valor.matches("^(?=[^A-Za-z]+$).*[0-9].*$") ) {
			addMsgError("cadastrarMesalista_erroValorMensalInvalido");
		}
		if ( isEmpty(idCartao) ) {
			addMsgError("cadastrarMesalista_erroCartao");
		}
		if ( !validaTelefones() ) {
			addMsgError("cadastrarMesalista_erroTelefones");
		}
		if ( !validaDocumentos() ) {
			addMsgError("cadastrarMesalista_erroDocumento");
		}
	}
	
	private boolean validaTelefones() {
		if ( isEmpty(telCelular) && isEmpty(telResidencial) 
				&& isEmpty(telComercial) ) {
			return false;
		}
		return true;
	}
	
	private boolean validaDocumentos() {
		if ( isEmpty(rg) && isEmpty(cpf) && isEmpty(cnpj) ) {
			return false;
		}
		return true;
	}
	
}