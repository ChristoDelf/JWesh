package be.superteam.forum.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jwesh.action.Action;
import org.jwesh.action.result.ActionResult;
import org.jwesh.action.result.ViewResult;

public class DisplayLoginAction implements Action {

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Entry in DisplayLoginAction - Method " + request.getMethod());
		
		request.setAttribute("title", "Login");
		return new ViewResult("login");
		// On évite ici de rediriger vers la page .jsp avec les méthodes forward, etc
	}

}
