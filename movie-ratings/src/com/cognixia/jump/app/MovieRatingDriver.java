package com.cognixia.jump.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.cognixia.jump.controller.AuthController;
import com.cognixia.jump.dao.AuthDAO;
import com.cognixia.jump.dao.MovieDAO;
import com.cognixia.jump.dao.RatingDAO;
import com.cognixia.jump.model.Movie;
import com.cognixia.jump.model.Rating;
import com.cognixia.jump.model.User;
import com.cognixia.jump.service.Menu;
import com.cognixia.jump.utility.Message;

public class MovieRatingDriver {
	
	public static void main(String[] args) {
		 Message.title("--- Welcome to Movie Ratings ---");
		 	AuthController auth = new AuthController();
		    boolean isQuit = false;
		    do {
		      Menu.mainDisplay();
		      Scanner sc = new Scanner(System.in);
		      Message.message("Select An Option by choosing a number: ");
		      String expression = sc.nextLine();
		      switch (expression) {
		        case "1":
		          auth.authController();
		          break;
		        case "2":
		          auth.createUser();
		          break;
		        case "3":
		          sc.close();
		          isQuit = true;
		          Message.message("Quit. Thanks for using Movie Ratings. Bye.");
		          break;
		        default:
		          Message.error("This is invalid option. Pick 1, 2, 3.");
		      }
		    } while (!isQuit);
		  }
}
