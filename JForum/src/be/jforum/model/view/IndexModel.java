package be.jforum.model.view;

import java.util.List;

public class IndexModel {

	private String title;
	private List<TopicModel> topics;
	
	public IndexModel() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<TopicModel> getTopics() {
		return topics;
	}

	public void setTopics(List<TopicModel> topics) {
		this.topics = topics;
	}
}
