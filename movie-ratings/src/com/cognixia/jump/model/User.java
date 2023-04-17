package com.cognixia.jump.model;

import java.util.List;

public class User {
	
	private int user_id;
	private String name;
	
	private String email;
	
	private List<Rating> ratings;
	
	private String password;
	
	public User() {
		super();
		this.user_id = 0;
		this.name = "n/a";
		this.email = "n/a";
		this.ratings = null;
		this.password = "n/a";
	}

	public User(int user_id, String name, String email,  String password, List<Rating> ratings) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.ratings = ratings;
		this.password = password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", email=" + email + ", ratings=" + ratings + "]";
	}
	
}
