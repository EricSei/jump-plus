package com.cognixia.jump.controller;

import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.dao.MovieDAO;
import com.cognixia.jump.model.Movie;
import com.cognixia.jump.utility.Message;

public class MovieController {
	
	public static void viewMovies() {
		
		MovieDAO movieDAO = new MovieDAO();
		List<Movie> movieList = movieDAO.getMovies();
		Message.title("Movies Table");
		for(Movie mv: movieList) {
			Message.message(mv.toString());
		}
		
	}
}
