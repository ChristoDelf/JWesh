package be.superteam.forum;

import javax.servlet.annotation.WebListener;

import org.jwesh.AppInit;
import org.jwesh.action.ActionMan;
import org.jwesh.action.mapping.Mapping;

import be.superteam.forum.action.AddMessageAction;
import be.superteam.forum.action.AddTopicAction;
import be.superteam.forum.action.CheckLoginAction;
import be.superteam.forum.action.DisconnectAction;
import be.superteam.forum.action.DisplayLoginAction;
import be.superteam.forum.action.IndexAction;
import be.superteam.forum.action.DisplayTopicAction;
import be.superteam.forum.action.SignUpAction;

@WebListener
public class Init extends AppInit {

	@Override
	public void registerActions(ActionMan manager) {
		manager.addAction(Mapping.get("/"), new IndexAction());
		
		manager.addAction(Mapping.get("/index"), new IndexAction());
		manager.addAction(Mapping.get("/login"), new DisplayLoginAction());
		manager.addAction(Mapping.post("/login"), new CheckLoginAction());
		manager.addAction(Mapping.get("/logout"), new DisconnectAction());
		manager.addAction(Mapping.post("/signup"), new SignUpAction());
		
		manager.addAction(Mapping.get("/topic"), new DisplayTopicAction());
		manager.addAction(Mapping.post("/topic"), new AddTopicAction());
		
		manager.addAction(Mapping.post("/message"), new AddMessageAction());
	}

}
