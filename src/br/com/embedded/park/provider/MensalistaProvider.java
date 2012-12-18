package br.com.embedded.park.provider;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.embedded.park.annotation.Transactional;
import br.com.embedded.park.dao.DocumentoDao;
import br.com.embedded.park.dao.MensalistaDao;
import br.com.embedded.park.entity.Cartao;
import br.com.embedded.park.entity.Documento;
import br.com.embedded.park.entity.Mensalista;
import br.com.embedded.park.entity.Uf;
import br.com.embedded.park.exception.BusinessException;
import br.com.embedded.park.service.CartaoService;
import br.com.embedded.park.service.ContatoService;
import br.com.embedded.park.service.ContratoService;
import br.com.embedded.park.service.DocumentoService;
import br.com.embedded.park.service.EnderecoService;
import br.com.embedded.park.service.MensalistaService;
import br.com.embedded.park.service.UfService;

/**
 * 
 * @author - Jader Assis
 *
 */
public class MensalistaProvider implements MensalistaService {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private MensalistaDao mensalistaDao;
	@Inject
	private ContatoService contatoService;
	@Inject
	private ContratoService contratoService;
	@Inject
	private EnderecoService enderecoService;
	@Inject
	private CartaoService cartaoService;
	@Inject
	private UfService ufService;
	@Inject
	private DocumentoService documentoService;
	@Inject
	private DocumentoDao documentoDao;
	
	@Transactional
	public void cadastrarMensalista(Mensalista mensalista, Long idCartao, Long idUf,
			List<Documento> listaDocumentosMensalista) throws BusinessException {
		
		mensalista.setDataInicioVigencia(new Date());
		mensalista.setDocumentos(listaDocumentosMensalista);
		
		Cartao cartao = cartaoService.findById(idCartao);
		mensalista.setCartao(cartao);
		Uf uf = ufService.findById(idUf);
		mensalista.getEndereco().setUf(uf);
		
		contatoService.salvar(mensalista.getContato());
		contratoService.salvar(mensalista.getContrato());
		enderecoService.salvar(mensalista.getEndereco());
		mensalistaDao.salvar(mensalista);
		
		if ( isNotEmpty(mensalista.getDocumentos()) ) {
			for (Documento documento : mensalista.getDocumentos()  ) {
				documento.setMensalista(mensalista);
				documentoDao.salvar(documento);
			}
		}
		
	}

	@SuppressWarnings("rawtypes")
	private boolean isNotEmpty(Collection collection) {
		if (collection == null || collection.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public Mensalista findByCartao(Cartao cartao) {
		return mensalistaDao.findByCartao(cartao);
	}
}
