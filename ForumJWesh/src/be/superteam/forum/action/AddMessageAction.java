package be.superteam.forum.action;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jwesh.action.Action;
import org.jwesh.action.result.ActionResult;
import org.jwesh.action.result.RedirectResult;
import org.jwesh.action.result.ViewResult;

import be.superteam.forum.model.Post;
import be.superteam.forum.service.DBService;

public class AddMessageAction implements Action {

	DBService dbs = new DBService();
	
	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Entry in AddMessageAction - Method " + request.getMethod());

		int topicId = Integer.valueOf(request.getParameter("topic"));
		Post post = new Post(0, request.getParameter("text"), Integer.valueOf(request.getParameter("author")),
				LocalDate.now(), topicId);
		
		if (dbs.insertPost(post)) {
			System.out.println("\tMessage " + post + " correctement inséré => retour à la page du topic");
			return new RedirectResult("topic?topic=" + topicId);
		} else {
			System.out.println("\tQuelque chose s'est mal passé => retour à la page d'accueil");
			request.setAttribute("erreur", "Impossible de créer un nouveau message, veuillez ré-essayer plus tard");
			return new ViewResult("index");
		}
	}

}
