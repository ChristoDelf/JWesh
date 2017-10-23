package org.jwesh.demo;

import javax.servlet.annotation.WebListener;

import org.jwesh.AppInit;
import org.jwesh.action.ActionMan;
import org.jwesh.action.mapping.Mapping;
import org.jwesh.demo.action.IndexAction;

@WebListener

public class Init extends AppInit {

	@Override
	public void registerActions(ActionMan manager) {
		manager.addAction(Mapping.get("/"), new IndexAction());
//		manager.addAction(new Mapping.Builder().withMethodGet().withUrl("/").build(), new IndexAction());
	}

}
