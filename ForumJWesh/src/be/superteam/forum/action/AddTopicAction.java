package be.superteam.forum.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jwesh.action.Action;
import org.jwesh.action.result.ActionResult;
import org.jwesh.action.result.RedirectResult;
import org.jwesh.action.result.ViewResult;

import be.superteam.forum.model.Topic;
import be.superteam.forum.service.DBService;

public class AddTopicAction implements Action {

	DBService dbs = new DBService();

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Entry in AddTopicAction - Method " + request.getMethod());

		Topic topic = new Topic(0, request.getParameter("title"), Integer.valueOf(request.getParameter("creator")));
		
		if (dbs.insertTopic(topic)) {
			System.out.println("\tTopic " + topic + " correctement inséré => retour à la page d'accueil");
			return new RedirectResult("index");
		} else {
			System.out.println("\tQuelque chose s'est mal passé => retour à la page d'accueil");
			request.setAttribute("erreur", "Impossible de créer un nouveau topic, veuillez ré-essayer plus tard");
			return new ViewResult("index");
		}
	}

}
