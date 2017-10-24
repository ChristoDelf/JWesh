package be.jforum.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jwesh.action.Action;
import org.jwesh.action.result.ActionResult;
import org.jwesh.action.result.RedirectResult;
import org.jwesh.action.result.ViewResult;

import be.jforum.model.db.User;
import be.jforum.service.UserManager;

public class PostSignUpAction implements Action {

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordCheck = request.getParameter("passwordcheck");
		
		String errorMessage = "";
		
		if (password.equals(passwordCheck)) {

			if (!UserManager.getInstance().userExists(username)) {
				
				User user = new User(username, password);
				user = UserManager.getInstance().signUp(user);
				if (user != null) {
					return new RedirectResult("/signin");
				} else {
					errorMessage = "Unknown error";
				}
			} else {
				errorMessage = "Username taken";
			}
		} else {
			errorMessage = "Passwords don't match";
		}
		
		request.setAttribute("errorMessage", errorMessage);
		return new ViewResult("signup");
	}
}
