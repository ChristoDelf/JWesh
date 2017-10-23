package org.jwesh;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jwesh.action.ActionMan;

// Impl�mentation classique d'une classe abstraite � pr�senter un utilisateur externe
public abstract class AppInit implements ServletContextListener {
	
	// Ceci est la m�thode r�elle, mais avec un nom pourri, invisible de l'utilisateur
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		registerActions(ActionMan.getInstance());
	} 

	//Ceci est la m�thode vue par l'utilisateur
	public abstract void registerActions(ActionMan manager);
}
