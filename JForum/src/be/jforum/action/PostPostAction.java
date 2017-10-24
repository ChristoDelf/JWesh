package be.jforum.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jwesh.action.Action;
import org.jwesh.action.result.ActionResult;
import org.jwesh.action.result.RedirectResult;

import be.jforum.model.db.Post;
import be.jforum.model.db.User;
import be.jforum.service.ForumManager;

public class PostPostAction implements Action {

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String topicIdParam = request.getParameter("topicId");
		String message = request.getParameter("message");
		
		int topicId = Integer.parseInt(topicIdParam);
		
		Post post = new Post();
		post.setCreator((User) request.getSession().getAttribute("user"));
		post.setContent(message);
		ForumManager.getInstance().addPostToTopic(post, topicId);
		
		return new RedirectResult("/topic?id=" + topicId);
	}
}
