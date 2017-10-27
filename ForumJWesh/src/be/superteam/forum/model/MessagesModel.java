package be.superteam.forum.model;

import java.util.Map;

public class MessagesModel {

	private String title;
	private Map<Post, User> listeMessages;
	private int topicId;
	
	public MessagesModel(String title, Map<Post, User> listeMessages, int topicId) {
		this.title = title;
		this.listeMessages = listeMessages;
		this.topicId = topicId;
	}

	public String getTitle() {
		return title;
	}

	public Map<Post, User> getListeMessages() {
		return listeMessages;
	}

	public int getTopicId() {
		return topicId;
	}
	
}
