package br.com.embedded.park.listener;

import javax.enterprise.event.Observes;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.inject.Inject;

import org.jboss.seam.faces.event.qualifier.After;
import org.jboss.seam.faces.event.qualifier.RestoreView;

import br.com.embedded.park.controller.UsuarioLogadoController;

public class LoginListener {

	@Inject
	private NavigationHandler handler;
	
	@Inject
	private UsuarioLogadoController usuarioLogado;
	
	@Inject
	private FacesContext context;
	
	public void autoriza(@Observes @After @RestoreView PhaseEvent event){
		
		if( "/app/login.xhtml".equals(context.getViewRoot().getViewId()) ){
			return;
		}
		
		if( !usuarioLogado.isLogado() ) {
			handler.handleNavigation(context, null, "/app/login?faces-redirect=true");
		}
	}
	
}
