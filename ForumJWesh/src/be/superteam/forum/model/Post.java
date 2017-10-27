package be.superteam.forum.model;

import java.time.LocalDate;

public class Post {

	private int id;
	private String text;
	private int author;
	private LocalDate date;
	private int topic;
	
	public Post() {
	}
	
	public Post(int id, String text, int author, LocalDate date, int topic) {
		this.id = id;
		this.text = text;
		this.author = author;
		this.date = date;
		this.topic = topic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getTopic() {
		return topic;
	}

	public void setTopic(int topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", " + (text != null ? "text=" + text + ", " : "") + "author=" + author + ", "
				+ (date != null ? "date=" + date + ", " : "") + "topic=" + topic + "]";
	}
}
