package org.jwesh.demo.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jwesh.action.Action;
import org.jwesh.action.result.ActionResult;
import org.jwesh.action.result.ViewResult;

public class IndexAction implements Action {

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setAttribute("title", "Titre de la page");
		return new ViewResult("index");
		// On évite ici de rediriger vers la page .jsp avec les méthodes forward, etc
	}

}
