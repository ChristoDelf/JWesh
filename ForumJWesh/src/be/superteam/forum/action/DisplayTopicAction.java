package be.superteam.forum.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jwesh.action.Action;
import org.jwesh.action.result.ActionResult;
import org.jwesh.action.result.ViewResult;

import be.superteam.forum.model.MessagesModel;
import be.superteam.forum.model.Post;
import be.superteam.forum.model.Topic;
import be.superteam.forum.model.User;
import be.superteam.forum.service.DBService;

public class DisplayTopicAction implements Action {

	DBService dbs = new DBService();
	
	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Entry in ListMessagesAction - Method " + request.getMethod());
		
		int topicId = Integer.parseInt(request.getParameter("topic"));
		Topic topic = dbs.getTopicById(topicId);
		List<Post> messages = dbs.getMessagesByTopic(topicId);
		
		
		
		Map<Post, User> listeMessages = new HashMap<>();
		for (Post message : messages) {

			listeMessages.put(message, dbs.getUserById(message.getAuthor()));
		}
		MessagesModel messagesModel = new MessagesModel(topic.getTitle(), listeMessages, topicId);
		request.setAttribute("model", messagesModel);

		return new ViewResult("topic");
	}

}
