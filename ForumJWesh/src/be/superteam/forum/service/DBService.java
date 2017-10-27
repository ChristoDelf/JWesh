package be.superteam.forum.service;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.superteam.forum.model.Post;
import be.superteam.forum.model.Topic;
import be.superteam.forum.model.User;

public class DBService {

	// Database stuff
	private String dbName = "Forum";
	private Statement stmt = null;
	private static Connection conn = null;

//	private static DBService instance = null;
//	
	public DBService() {
		if (conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName + "?user=root&password=root");
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}	
	}
	
public User insertUser(User user) {
		PreparedStatement insertUser = null;
		ResultSet rs = null;
		
		
		String query = "INSERT INTO user (login, password, statut) VALUES (?, ?, ?)";
	
		try {
			insertUser = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			insertUser.setString(1, user.getLogin());
			insertUser.setString(2, user.getPassword());
			insertUser.setBoolean(3, user.isActive());
	
			insertUser.execute();
			
			rs = insertUser.getGeneratedKeys();
			rs.next();
			int userId = rs.getInt(1);
	
			user = getUserById(userId);
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ignore) {}
			}
			if (insertUser != null) {
				try {
					insertUser.close();
				} catch (SQLException ignore) {}
			}
		}
		return user;
	}

	//	public static DBService getInstance() {
//		if(instance == null) {
//			instance = new DBService();
//		}
//		return instance;
//	}
//	
	public List<User> getUsers() {
			ResultSet rs = null;
			List<User> users = new ArrayList<>();
	
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM user");// A JOIN combobox C on A.type = C.id");
				while(rs.next()) {
					User user = new User(
							rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getBoolean("statut"));
					if (user.isActive())
						users.add(user);
				} 
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException ignore) {}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException ignore) {}
				}
			}
			return users.stream().sorted(comparing(User::getId)).collect(toList());
		}

	public User getUserById(int userId) {
		PreparedStatement getUser = null;
		ResultSet rs = null;
		String query = "SELECT * FROM user WHERE id = ?";
		User user = null;
	
		try {
			getUser = conn.prepareStatement(query);
			getUser.setInt(1, userId);
			rs = getUser.executeQuery();
			if (rs.next())
			user = new User(
					rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getBoolean("statut"));
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ignore) {}
			}
			if (getUser != null) {
				try {
					getUser.close();
				} catch (SQLException ignore) {}
			}
		}
		return user;
	}

	public User getUserByLogin(String login) {
		PreparedStatement getUser = null;
		ResultSet rs = null;
		String query = "SELECT * FROM user WHERE login = ?";
		User user = null;

		try {
			getUser = conn.prepareStatement(query);
			getUser.setString(1, login);
			rs = getUser.executeQuery();
			if (rs.next())
			user = new User(
					rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getBoolean("statut"));
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ignore) {}
			}
			if (getUser != null) {
				try {
					getUser.close();
				} catch (SQLException ignore) {}
			}
		}
		return user;
	}

	public boolean insertTopic(Topic topic) {
		PreparedStatement insertTopic = null;
		ResultSet rs = null;
		boolean reussi = false;
		
		String query = "INSERT INTO topic (title, creator) VALUES (?, ?)";
	
		try {
			insertTopic = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			insertTopic.setString(1, topic.getTitle());
			insertTopic.setInt(2,  topic.getCreator());
	
			insertTopic.execute();
			reussi = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ignore) {}
			}
			if (insertTopic != null) {
				try {
					insertTopic.close();
				} catch (SQLException ignore) {}
			}
		}
		return reussi;
	}

	public List<Topic> getTopics() {
		ResultSet rs = null;
		List<Topic> topics = new ArrayList<>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM topic");// A JOIN combobox C on A.type = C.id");
			while(rs.next()) {
				Topic topic = new Topic(
						rs.getInt("id"), rs.getString("title"), rs.getInt("creator"));
				topics.add(topic);
			} 
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ignore) {}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException ignore) {}
			}
		}
		return topics.stream().sorted(comparing(Topic::getId)).collect(toList());
	}

	public Topic getTopicById(int topicId) {
		PreparedStatement getTopic = null;
		ResultSet rs = null;
		String query = "SELECT * FROM topic WHERE id = ?";
		Topic topic = null;
	
		try {
			getTopic = conn.prepareStatement(query);
			getTopic.setInt(1, topicId);
			rs = getTopic.executeQuery();
			if (rs.next())
			topic = new Topic(rs.getInt("id"), rs.getString("title"), rs.getInt("creator"));
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ignore) {}
			}
			if (getTopic != null) {
				try {
					getTopic.close();
				} catch (SQLException ignore) {}
			}
		}
		return topic;
	}

	public List<Post> getMessagesByTopic(int topicId) {
		ResultSet rs = null;
		List<Post> posts = new ArrayList<>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM post WHERE topic = " + topicId);// A JOIN combobox C on A.type = C.id");
			while(rs.next()) {
				Post post = new Post(rs.getInt("id"), rs.getString("text"), rs.getInt("author"), rs.getDate("date").toLocalDate()
						, rs.getInt("topic"));
				posts.add(post);
			} 
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ignore) {}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException ignore) {}
			}
		}
		return posts.stream().sorted(comparing(Post::getDate)).collect(toList());
	}

	public boolean insertPost(Post post) {
		PreparedStatement insertPost = null;
		ResultSet rs = null;
		boolean reussi = false;
		
		String query = "INSERT INTO post (text, author, date, topic) VALUES (?, ?, ?, ?)";
	
		try {
			insertPost = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			insertPost.setString(1, post.getText());
			insertPost.setInt(2,  post.getAuthor());
			insertPost.setDate(3, Date.valueOf(post.getDate()));
			insertPost.setInt(4, post.getTopic());
	
			insertPost.execute();
			reussi = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ignore) {}
			}
			if (insertPost != null) {
				try {
					insertPost.close();
				} catch (SQLException ignore) {}
			}
		}
		return reussi;
	}
}
