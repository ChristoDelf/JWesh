package be.superteam.forum.model;

import java.util.Map;

public class IndexModel {

	private String title;
	private Map<Topic, User> listeTopics;
	
	public IndexModel(String title, Map<Topic, User> listeTopics) {
		this.title = title;
		this.listeTopics = listeTopics;
	}

	public String getTitle() {
		return title;
	}

	public Map<Topic, User> getListeTopics() {
		return listeTopics;
	}
	
	
}
