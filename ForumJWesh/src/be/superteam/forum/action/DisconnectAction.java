package be.superteam.forum.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jwesh.action.Action;
import org.jwesh.action.result.ActionResult;
import org.jwesh.action.result.ViewResult;

public class DisconnectAction implements Action {

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Entry in DisconnectAction - Method " + request.getMethod());
		request.getSession().invalidate();
		
		request.setAttribute("title", "Logout");
		request.setAttribute("message", "Vous avez été correctement déconnecté(e)");
		return new ViewResult("login");
	}

}
