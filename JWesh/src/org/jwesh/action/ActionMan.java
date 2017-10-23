package org.jwesh.action;

import java.util.HashMap;
import java.util.Map;

import org.jwesh.action.mapping.Mapping;

public class ActionMan {

	private static ActionMan instance;
	
	//TODO : replace String by something else
	private Map<Mapping, Action> actions;
	
	public static ActionMan getInstance() {
		if (instance == null) {
			instance = new ActionMan();
		}
		return instance;
	}
	
	private ActionMan() {		
		actions = new HashMap<>();
	}
	
	public void addAction(Mapping mapping, Action action) {
		actions.put(mapping, action);
	}
	
	public Action getAction(Mapping mapping) {
		return actions.get(mapping);
	}
	
	//TODO : Remove and rename actions
}
