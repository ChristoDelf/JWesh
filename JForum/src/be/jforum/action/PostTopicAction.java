package be.jforum.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jwesh.action.Action;
import org.jwesh.action.result.ActionResult;
import org.jwesh.action.result.RedirectResult;

import be.jforum.model.db.Post;
import be.jforum.model.db.Topic;
import be.jforum.model.db.User;
import be.jforum.service.ForumManager;

public class PostTopicAction implements Action {

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		User currentUser = (User) request.getSession().getAttribute("user");
		
		String title = request.getParameter("title");
		String message = request.getParameter("message");
		
		Topic topic = new Topic();
		topic.setTitle(title);
		topic.setCreator(currentUser);
		
		Post firstPost = new Post();
		firstPost.setContent(message);
		firstPost.setCreator(currentUser);
		
		ForumManager.getInstance().addTopic(topic, firstPost);
		
		return new RedirectResult("/topic?id=" + topic.getId());
	}
}
