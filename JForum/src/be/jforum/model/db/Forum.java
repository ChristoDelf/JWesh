package be.jforum.model.db;

import java.util.List;

public class Forum {

	private String title;
	private List<Topic> topics;
	
	public Forum() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
}
