package be.jforum.service;

import java.util.ArrayList;
import java.util.List;

import be.jforum.model.db.Forum;
import be.jforum.model.db.Post;
import be.jforum.model.db.Topic;

public class ForumManager {
	
	private static ForumManager instance;
	
	public static ForumManager getInstance() {
		if (instance == null) {
			instance = new ForumManager();
		}
		return instance;
	}
	
	private ForumManager() {
	}
	
	private Forum forum;
	
	public Forum getForum() {
		if (forum == null) {
			forum = new Forum();
			forum.setTitle("JForum");
			forum.setTopics(new ArrayList<>());
		}
		return forum;
	}
	
	private int nextTopicId = 1;
	
	private int nextPostId = 1;
	
	public Topic addTopic(Topic topic, Post firstPost) {
		topic.setId(nextTopicId);
		topic.setPosts(new ArrayList<>());
		nextTopicId++;
		forum.getTopics().add(topic);
		addPostToTopic(firstPost, topic.getId());
		return topic;
	}
	
	public List<Topic> getAllTopics() {
		return forum.getTopics();
	}
	
	public Topic getTopicById(int id) {
		return forum.getTopics()
				.stream()
				.filter(t -> t.getId() == id)
				.findFirst()
				.orElse(null);
	}
	
	public Post addPostToTopic(Post post, int topicId) {
		post.setId(nextPostId);
		nextPostId++;
		getTopicById(topicId).getPosts().add(post);
		return post;
	}
}
