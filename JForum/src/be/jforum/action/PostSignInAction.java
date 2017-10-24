package be.jforum.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jwesh.action.Action;
import org.jwesh.action.result.ActionResult;
import org.jwesh.action.result.RedirectResult;
import org.jwesh.action.result.ViewResult;

import be.jforum.model.db.User;
import be.jforum.service.UserManager;

public class PostSignInAction implements Action {

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = UserManager.getInstance().signIn(username, password);
		
		if (user != null) {

			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("connected", true);
			
			return new RedirectResult("/");
		}

		request.setAttribute("errorMessage", "Wrong username or password");
		return new ViewResult("signin");
	}
}
