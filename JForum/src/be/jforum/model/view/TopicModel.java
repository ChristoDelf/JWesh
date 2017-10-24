package be.jforum.model.view;

import java.util.List;

public class TopicModel {

	private int id;
	private String title;
	private String message;
	private String creator;
	private List<PostModel> posts;
	
	public TopicModel() {
	}

	public TopicModel(int id, String title, String message, String creator) {
		this.id = id;
		this.title = title;
		this.message = message;
		this.creator = creator;
	}

	public TopicModel(int id, String title, String creator, List<PostModel> posts) {
		this.id = id;
		this.title = title;
		this.creator = creator;
		this.posts = posts;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public List<PostModel> getPosts() {
		return posts;
	}
	
	public void setPosts(List<PostModel> posts) {
		this.posts = posts;
	}
}
