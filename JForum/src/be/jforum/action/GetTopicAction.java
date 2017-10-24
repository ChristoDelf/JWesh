package be.jforum.action;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jwesh.action.Action;
import org.jwesh.action.result.ActionResult;
import org.jwesh.action.result.ViewResult;

import be.jforum.model.db.Topic;
import be.jforum.model.view.PostModel;
import be.jforum.model.view.TopicModel;
import be.jforum.service.ForumManager;

public class GetTopicAction implements Action {

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String idParam = request.getParameter("id");
		int id = Integer.parseInt(idParam);
		
		Topic topic = ForumManager.getInstance().getTopicById(id);
		
		TopicModel model = new TopicModel(
				topic.getId(), 
				topic.getTitle(), 
				topic.getCreator().getUsername(), 
				topic.getPosts()
					.stream()
					.map(p -> new PostModel(p.getId(), p.getCreator().getUsername(), p.getContent()))
					.collect(Collectors.toList()));
		
		request.setAttribute("model", model);
		
		return new ViewResult("topic");
	}
}
