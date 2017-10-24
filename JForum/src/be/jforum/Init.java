package be.jforum;

import javax.servlet.annotation.WebListener;

import org.jwesh.AppInit;
import org.jwesh.action.ActionManager;
import org.jwesh.action.mapping.Mapping;

import be.jforum.action.GetIndexAction;
import be.jforum.action.GetSignInAction;
import be.jforum.action.GetSignUpAction;
import be.jforum.action.GetTopicAction;
import be.jforum.action.PostPostAction;
import be.jforum.action.PostSignInAction;
import be.jforum.action.PostSignOutAction;
import be.jforum.action.PostSignUpAction;
import be.jforum.action.PostTopicAction;

@WebListener
public class Init extends AppInit {

	@Override
	protected void registerActions(ActionManager manager) {
		manager.addAction(Mapping.get("/"), new GetIndexAction());
		manager.addAction(Mapping.get("/signin"), new GetSignInAction());
		manager.addAction(Mapping.post("/signin"), new PostSignInAction());
		manager.addAction(Mapping.get("/signup"), new GetSignUpAction());
		manager.addAction(Mapping.post("/signup"), new PostSignUpAction());
		manager.addAction(Mapping.get("/topic"), new GetTopicAction());
		manager.addAction(Mapping.post("/topic"), new PostTopicAction());
		manager.addAction(Mapping.post("/post"), new PostPostAction());
		manager.addAction(Mapping.post("/signout"), new PostSignOutAction());
	}
}
