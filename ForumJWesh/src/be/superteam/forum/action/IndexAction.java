package be.superteam.forum.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jwesh.action.Action;
import org.jwesh.action.result.ActionResult;
import org.jwesh.action.result.ViewResult;

import be.superteam.forum.model.IndexModel;
import be.superteam.forum.model.Topic;
import be.superteam.forum.model.User;
import be.superteam.forum.service.DBService;

public class IndexAction implements Action {

	DBService dbs = new DBService();//.getInstance();

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Entry in IndexAction - Method " + request.getMethod());

		if (request.getSession().getAttribute("user") == null) {
			System.out.println("\tUser non connecté => Affichage de la page de login");
			return new ViewResult("login");
		}
		
		System.out.println("\tUser déjà connecté => Affichage de la page d'accueil");

		Map<Topic, User> listeTopics = new HashMap<>();
		for (Topic topic : dbs.getTopics()) {

			listeTopics.put(topic, dbs.getUserById(topic.getCreator()));
		}
		IndexModel indexModel = new IndexModel("Forum des cousettes", listeTopics);
		request.setAttribute("model", indexModel);

		return new ViewResult("index");
	}

}
