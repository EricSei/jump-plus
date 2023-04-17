package com.cognixia.jump.controller;

import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.dao.RatingDAO;
import com.cognixia.jump.model.Rating;
import com.cognixia.jump.utility.Message;

public class RatingController {
	
	public static void rateMovie(int userId) {
		Scanner sc = new Scanner(System.in);
		Message.message("Type the number of the movie");
		int movieId = sc.nextInt();
		
		Message.message("Type the rating score from 1-5");
		int score = sc.nextInt();
		
		RatingDAO ratingDAO = new RatingDAO();
		
		boolean rated = ratingDAO.createRating(new Rating(0, userId, movieId, score));
		if(rated) {
			Message.message("Movie is rated");
		}else {
			Message.error("Something went wrong !");
		}
		
		
		
	}
	
	public static void viewRatings(int userId){
		Message.message("Getting All Your Rating");
		RatingDAO ratingDAO = new RatingDAO();
		List<Rating> ratingList =  ratingDAO.ratingsByUser(userId);
		
		for( Rating rs : ratingList ) {
			System.out.println(rs.toString());
		}
		
	}
}
