package be.superteam.forum.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jwesh.action.Action;
import org.jwesh.action.result.ActionResult;
import org.jwesh.action.result.RedirectResult;
import org.jwesh.action.result.ViewResult;

import be.superteam.forum.util.BCrypt;
import be.superteam.forum.service.DBService;
import be.superteam.forum.model.User;

public class CheckLoginAction implements Action {
	
	DBService dbs = new DBService();//.getInstance();

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Entry in CheckLoginAction - Method " + request.getMethod());
		
		User user = dbs.getUserByLogin(request.getParameter("login"));
		System.out.println("\tUser retrieved : " + user);

		if (user != null && BCrypt.checkpw(request.getParameter("password"), user.getPassword())) {
			System.out.println("\tUtilisateur retrouvé et password correct => accès à la page d'accueil");
			request.getSession().setAttribute("user", user);
			return new RedirectResult("index");
		} else {
			System.out.println("\tUtilisateur inconnu ou password incorrect => retour à la page de login");
			request.setAttribute("erreur", "Mauvais login/password. Veuillez ré-essayer");
			return new ViewResult("login");
		}
	}

}
