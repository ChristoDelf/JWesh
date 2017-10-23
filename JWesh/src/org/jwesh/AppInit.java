package org.jwesh;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jwesh.action.ActionMan;

// Implémentation classique d'une classe abstraite à présenter un utilisateur externe
public abstract class AppInit implements ServletContextListener {
	
	// Ceci est la méthode réelle, mais avec un nom pourri, invisible de l'utilisateur
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		registerActions(ActionMan.getInstance());
	} 

	//Ceci est la méthode vue par l'utilisateur
	public abstract void registerActions(ActionMan manager);
}
