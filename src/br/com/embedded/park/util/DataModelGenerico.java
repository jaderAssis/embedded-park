package br.com.embedded.park.util;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;

import br.com.embedded.park.dao.DaoPaginacao;
import br.com.embedded.park.entity.Usuario;

/**
 * Paginador generico
 *  
 */
public class DataModelGenerico<T> extends LazyDataModel<T> {

	private static final long serialVersionUID = 1L;
	private DaoPaginacao paginacao;
	private Usuario usuario;
	
	@SuppressWarnings("unchecked")
	public List<T> load(int firstResult, int maxResults, String campoOrdenacao, 
			boolean sentidoOrdenacao, Map<String, String> filtros) {
		
		return (List<T>) paginacao.listaPaginada(firstResult, maxResults, usuario);
	}

	/**
	 * Construtor
	 * 
	 * @author Jader Assis
	 * @param paginacao
	 */
	public DataModelGenerico(DaoPaginacao paginacao, Usuario usuario) {
		super();
		this.paginacao = paginacao;
		this.usuario = usuario;
		this.setRowCount((int) paginacao.contaTodos(usuario));
		this.setPageSize(1);
	}

}
