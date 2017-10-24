package be.jforum.action;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jwesh.action.Action;
import org.jwesh.action.result.ActionResult;
import org.jwesh.action.result.ViewResult;

import be.jforum.model.db.Forum;
import be.jforum.model.view.IndexModel;
import be.jforum.model.view.TopicModel;
import be.jforum.service.ForumManager;

public class GetIndexAction implements Action {

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("Executing GetIndexAction");
		
		Forum forum = ForumManager.getInstance().getForum();
		
		IndexModel model = new IndexModel();
		model.setTitle(forum.getTitle());
		model.setTopics(forum.getTopics()
							.stream()
							.map(t -> new TopicModel(t.getId(),
									t.getTitle(), 
									t.getPosts().get(0).getContent(), 
									t.getCreator().getUsername()))
							.limit(10)
							.collect(Collectors.toList()));
		request.setAttribute("model", model);
		
		return new ViewResult("index");
	}
}
