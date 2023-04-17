package com.cognixia.jump.model;

public class Rating {
	private int id;
	private int userId;
	private int movieId;
	private int score; //1-5 , use enum
	
	public Rating() {
		super();
		this.id = -1;
		this.movieId = -1;
		this.userId = -1;
		this.score = -1;
	}
	
	public Rating(int id, int userId, int movieId, int score) {
		super();
		this.id = id;
		this.userId = userId;
		this.movieId = movieId;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", userId=" + userId + ", movieId=" + movieId + ", score=" + score + "]";
	}

	
}
