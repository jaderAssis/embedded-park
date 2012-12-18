package br.com.embedded.park.conversor;


/**
 * 
 * @author Jader Assis
 *
 */
/*@FacesConverter(forClass = Cartao.class)
@RequestScoped
public class CartaoConverter implements Converter {

	@Inject
	private EntityManager entityManager;
	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent comp, String value) {
		Long id = Long.valueOf(value);
		return entityManager.find(Cartao.class, id);
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent comp, Object value) {
		Cartao cartao = (Cartao) value;
		return cartao.getDescricao().toUpperCase();
	}

}
*/
