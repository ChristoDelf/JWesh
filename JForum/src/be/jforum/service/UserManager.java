package be.jforum.service;

import java.util.ArrayList;
import java.util.List;

import be.jforum.model.db.User;

public class UserManager {

	private static UserManager instance;
	
	public static UserManager getInstance() {
		if (instance == null) {
			instance = new UserManager();
		}
		return instance;
	}
	
	private UserManager() {
	}
	
	private int nextUserId = 1;
	
	private List<User> users = new ArrayList<>();
	
	public User signUp(User user) {
		user.setId(nextUserId);
		nextUserId++;
		users.add(user);
		return user;
	}
	
	public User signIn(String username, String password) {
		return users
				.stream()
				.filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
				.findFirst()
				.orElse(null);
	}
	
	public User getUserById(int id) {
		return users
				.stream()
				.filter(u -> u.getId() == id)
				.findFirst()
				.orElse(null);
	}

	public boolean userExists(String username) {
		return users
				.stream()
				.filter(u -> u.getUsername().equals(username))
				.count() > 0;
	}
}
