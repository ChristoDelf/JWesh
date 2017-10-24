package be.jforum.model.view;

public class PostModel {

	private int id;
	private String creator;
	private String content;
	
	public PostModel() {}
	
	public PostModel(int id, String creator, String content) {
		this.id = id;
		this.creator = creator;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
