package br.com.embedded.park.provider;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.primefaces.model.LazyDataModel;

import br.com.embedded.park.annotation.Transactional;
import br.com.embedded.park.dao.PontoEletronicoDao;
import br.com.embedded.park.entity.PontoEletronico;
import br.com.embedded.park.entity.Usuario;
import br.com.embedded.park.exception.BusinessException;
import br.com.embedded.park.service.PontoEletronicoService;
import br.com.embedded.park.util.DataModelGenerico;

/**
 * 
 * @author - Jader Assis
 *
 */
public class PontoEletronicoProvider implements PontoEletronicoService {

	@Inject
	private transient PontoEletronicoDao pontoEletronicoDao;
	
	@Transactional
	public void marcarPontoParaUsuario(Usuario usuario) throws BusinessException {
		Calendar calendar = Calendar.getInstance();
		
		PontoEletronico pontoEletronico = null;
		List<PontoEletronico> listPontoEletronico = pontoEletronicoDao.listPontosDoUsuario(usuario, 1);
	
		if ( !listPontoEletronico.isEmpty() ) {
			pontoEletronico = listPontoEletronico.get(0); 
		}
		
		if ( gerarNovoPonto(pontoEletronico) ) {
			pontoEletronico = setaDadosNovoPonto(pontoEletronico, usuario);
		}
		else if ( pontoEletronico.getDataEntrada() == null ) {
			pontoEletronico.setDataEntrada(calendar.getTime());
		}
		else if ( pontoEletronico.getDataSaidaAlmoco() == null ) {
			pontoEletronico.setDataSaidaAlmoco(calendar.getTime());
		}
		else if ( pontoEletronico.getDataVoltaAlmoco() == null ) {
			pontoEletronico.setDataVoltaAlmoco(calendar.getTime());
		}
		else if ( pontoEletronico.getDataSaida() == null ) {
			pontoEletronico.setDataSaida(calendar.getTime());
		}
		else {
			// usuario ja marcou todos os pontos do dia
			throw new BusinessException("pontoEletronico_erro01");
		}
				
		pontoEletronicoDao.saveOrUpdate(pontoEletronico);
	}
	
	private PontoEletronico setaDadosNovoPonto(PontoEletronico pontoEletronico, Usuario usuario) {
		Calendar calendar = Calendar.getInstance();
		
		pontoEletronico = new PontoEletronico();
		pontoEletronico.setDataEntrada(calendar.getTime());
		pontoEletronico.setUsuario(usuario);
		
		return pontoEletronico;
	}
	
	private boolean gerarNovoPonto(PontoEletronico pontoEletronico) {
		
		if ( pontoEletronico == null ) {
			return true;
		}
		if ( pontoEletronico.getDataEntrada() != null 
				&& !ultimoPontoBatidoFoiHoje(pontoEletronico.getDataEntrada()) ) {
			return true;
		}
		else  {
			return false;
		}
	}
	
	private boolean ultimoPontoBatidoFoiHoje(Date dataEntrada) {
		DateTime dataEntredaJoda = new DateTime(dataEntrada);
		DateTime dataAtual = new DateTime();
		
		return dataAtual.toString("dd/MM/yyyy").equals(dataEntredaJoda.toString("dd/MM/yyyy"));
	}

	/**
	 * Retorna objeto DataModel utilizado para paginacao
	 *  
	 * @author Jader Assis
	 * @since 08/08/2012 23:03:11
	 *
	 * @return
	 * {@inheritDoc}
	 */
	public LazyDataModel<PontoEletronico> getPaginador(Usuario usuario) {
		return new DataModelGenerico<PontoEletronico>(pontoEletronicoDao, usuario);
	}

}