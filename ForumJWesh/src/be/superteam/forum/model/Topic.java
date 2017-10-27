package be.superteam.forum.model;

public class Topic {

	private int id;
	private String title;
	private int creator;
	
	public Topic() {	
	}
	
	public Topic(int id, String title, int creator) {
		this.id = id;
		this.title = title;
		this.creator = creator;
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

	public int getCreator() {
		return creator;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", " + (title != null ? "title=" + title + ", " : "") + "creator=" + creator + "]";
	}

}
