package br.com.embedded.park.aop;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import br.com.embedded.park.annotation.Transactional;

@Interceptor
@Transactional
public class TransactionalInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final transient Logger logger = Logger
			.getLogger(TransactionalInterceptor.class);
	
	@Inject
	private EntityManager em;

	@AroundInvoke
	public Object intercept(InvocationContext ctx)throws Exception{

		if ( em.getTransaction().isActive() ) {
			return em.getTransaction();
		}

		logger.debug("*** Abrindo a transacao ***");
		
		em.getTransaction().begin();
		
		//passando para o JSF tratar a requisicao e pegando o retorno da pagina
		Object resultado = ctx.proceed();
		
		em.getTransaction().commit();
		logger.debug("*** Comitando a transacao ***");
		return resultado;
			
	}
}
