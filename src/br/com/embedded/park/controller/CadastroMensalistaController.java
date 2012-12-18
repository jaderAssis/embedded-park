package br.com.embedded.park.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.embedded.park.entity.Cartao;
import br.com.embedded.park.entity.Contato;
import br.com.embedded.park.entity.Contrato;
import br.com.embedded.park.entity.Documento;
import br.com.embedded.park.entity.Endereco;
import br.com.embedded.park.entity.Mensalista;
import br.com.embedded.park.entity.Uf;
import br.com.embedded.park.enuns.TipoDocumento;
import br.com.embedded.park.enuns.TipoEndereco;
import br.com.embedded.park.enuns.TipoPessoa;
import br.com.embedded.park.exception.BusinessException;
import br.com.embedded.park.service.CartaoService;
import br.com.embedded.park.service.MensalistaService;
import br.com.embedded.park.service.UfService;

/**
 * 
 * @author - Jader Assis
 *
 */
@Named
@ViewScoped
public class CadastroMensalistaController extends BaseController {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private transient UfService ufService;
	@Inject
	private transient MensalistaService mensalistaService;
	@Inject
	private transient CartaoService cartaoService;
	
	//variaveis de tela
	private Mensalista mensalista;
	private List<Uf> listUf;
	private List<TipoDocumento> listTipoDocumento;
	private List<TipoEndereco> listTipoEndereco;
	private List<Cartao> listCartoesLiberados;
	private List<TipoPessoa> listTiposPessoas;
	private Long idUf;
	private Long idCartao;
	private TipoPessoa tipoPessoa;
	private String rg;
	private String cpf;
	private String cnpj;
	private String valorContrato;
	
	@PostConstruct
	public void initialize() {
		limpaFormulario();
	}
	
	public void cadastrar(ActionEvent actionEvent) {
		
		try {
			
			String valor = valorContrato.replace(",", ".");
			mensalista.getContrato().setValor(new BigDecimal(valor));
			
			mensalistaService.cadastrarMensalista(mensalista, idCartao, idUf, getListaDocumentosMensalista());
			addMessageCadastroSucesso();
		}
		catch (BusinessException e) {
			addMessageErro(e.getMessage());
		}
		catch (Exception e) {
			addMessageErroGenerico(e.getMessage());
		}
	}

	private List<Documento> getListaDocumentosMensalista() {
		List<Documento> listDocumentos = new ArrayList<Documento>();
		
		if ( TipoPessoa.PESSOA_FISICA.equals(tipoPessoa) ) {
			if ( !isEmpty(rg) ) {
				Documento docRg = new Documento();
				docRg.setNumDocumento(rg.trim());
				docRg.setTipoDocumento(TipoDocumento.RG);
				listDocumentos.add(docRg);
			}
			if ( !isEmpty(cpf) ) {
				Documento docCpf = new Documento();
				docCpf.setNumDocumento(cpf.trim());
				docCpf.setTipoDocumento(TipoDocumento.CPF);
				listDocumentos.add(docCpf);
			}
		}
		else {
			if ( !isEmpty(cnpj) ) {
				Documento docCnpj = new Documento();
				docCnpj.setNumDocumento(cnpj.trim());
				docCnpj.setTipoDocumento(TipoDocumento.CNPJ);
				listDocumentos.add(docCnpj);
			}
		}
		return listDocumentos;
	}

	public void defineTipoPessoa(ValueChangeEvent event) {
		if ( event.getOldValue() != null && 
				!event.getOldValue().equals(event.getNewValue()) ) {
			tipoPessoa = (TipoPessoa) event.getNewValue();
		}
	}
	
	
	private void limpaFormulario() {
		mensalista = new Mensalista();
		mensalista.setEndereco(new Endereco());
		mensalista.setContato(new Contato());
		mensalista.setContrato(new Contrato());
		mensalista.setCartao(new Cartao());
		mensalista.setDocumentos(new ArrayList<Documento>());
		tipoPessoa = TipoPessoa.PESSOA_FISICA;
	}
	
	public Mensalista getMensalista() {
		return mensalista;
	}

	public void setMensalista(Mensalista mensalista) {
		this.mensalista = mensalista;
	}

	public List<Uf> getListUf() {
		if ( listUf == null ) {
			listUf = ufService.findAll();
		}
		return listUf;
	}

	public void setListUf(List<Uf> listUf) {
		this.listUf = listUf;
	}

	public List<TipoEndereco> getListTipoEndereco() {
		if ( listTipoEndereco == null ) {
			listTipoEndereco = new ArrayList<TipoEndereco>();
			for (TipoEndereco tipoEndereco : TipoEndereco.values()) {
				listTipoEndereco.add(tipoEndereco);
			}
		}
		return listTipoEndereco;
	}	

	public void setListTipoEndereco(List<TipoEndereco> listTipoEndereco) {
		this.listTipoEndereco = listTipoEndereco;
	}

	public List<TipoDocumento> getListTipoDocumento() {
		if ( listTipoDocumento == null ) {
			listTipoDocumento = new ArrayList<TipoDocumento>();
			for (TipoDocumento tipoDocumento : TipoDocumento.values()) {
				listTipoDocumento.add(tipoDocumento);
			}
		}
		return listTipoDocumento;
	}

	public void setListTipoDocumento(List<TipoDocumento> listTipoDocumento) {
		this.listTipoDocumento = listTipoDocumento;
	}

	public List<Cartao> getListCartoesLiberados() {
		if ( listCartoesLiberados == null ) {
			listCartoesLiberados = cartaoService.findAllCartoesLiberados();
		}
		
		return listCartoesLiberados;
	}

	public void setListCartoesLiberados(List<Cartao> listCartoesLiberados) {
		this.listCartoesLiberados = listCartoesLiberados;
	}

	public Long getIdUf() {
		return idUf;
	}

	public void setIdUf(Long idUf) {
		this.idUf = idUf;
	}

	public Long getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(Long idCartao) {
		this.idCartao = idCartao;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public List<TipoPessoa> getListTiposPessoas() {
		if ( listTiposPessoas == null ) {
			listTiposPessoas = new ArrayList<TipoPessoa>();
			
			for ( TipoPessoa pessoa : TipoPessoa.values() ) {
				listTiposPessoas.add(pessoa);
			}
		}
		return listTiposPessoas;
	}

	public void setListTiposPessoas(List<TipoPessoa> listTiposPessoas) {
		this.listTiposPessoas = listTiposPessoas;
	}

	public String getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(String valorContrato) {
		this.valorContrato = valorContrato;
	}

}