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

public class SignUpAction implements Action {

	DBService dbs = new DBService();//.getInstance();
	
	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Entry in SignUpAction - Method " + request.getMethod());
		
		User user = dbs.getUserByLogin(request.getParameter("login"));
		System.out.println("\tUser retrieved : " + user);

		if (user != null) {
			System.out.println("\tUtilisateur retrouvé => retour à la page de login");
			request.setAttribute("erreur", "Un utilisateur possède déjà ce compte, merci d'en utiliser un autre, ou "
					+ "de vous connecter par le formulaire de connexion");
			return new ViewResult("login");
		} else {
			// Hash a password for the first time
			String hashed = BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt());

			user = dbs.insertUser(new User(0, request.getParameter("login"), hashed));
			
			if (user != null) {
				System.out.println("\tUser " + user + " correctement inséré => retour à la page d'accueil");
				request.getSession().setAttribute("user", user);
				return new RedirectResult("index");
			} else {
				System.out.println("\tQuelque chose s'est mal passé => retour à la page de login");
				request.setAttribute("erreur", "Inscription impossible, veuillez ré-essayer plus tard.");
				return new ViewResult("login");
			}
		}
	}

}
