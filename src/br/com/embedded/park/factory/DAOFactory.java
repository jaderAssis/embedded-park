/*package br.com.embedded.park.factory;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.embedded.park.dao.Dao;

public class DAOFactory {

	@Inject
	EntityManager em;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Produces
	public Dao createDAO(InjectionPoint injectionPoint){ 
		
		ParameterizedType type = (ParameterizedType) injectionPoint.getType();
		Class classe = (Class) type.getActualTypeArguments()[0];
		
		//return new Dao(classe, em);
		return null;
	}
	
}
*/