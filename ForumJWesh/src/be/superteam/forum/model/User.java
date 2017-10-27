package be.superteam.forum.model;

public class User {

	private int id;
	private String login;
	private String password;
	private boolean statut;
	
	public User() {
		
	}
	
	public User(int id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.statut = true;
	}

	public User(int id, String login, String password, boolean statut) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.statut = statut;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return statut;
	}

	public void activate() {
		this.statut = true;
	}

	public void deActivate() {
		this.statut = false;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", " + (login != null ? "login=" + login + ", " : "")
				+ (password != null ? "password=" + password + ", " : "") + "statut=" + statut + "]";
	}
}
