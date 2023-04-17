package com.cognixia.jump.controller;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.cognixia.jump.dao.AuthDAO;
import com.cognixia.jump.dao.UserDAO;
import com.cognixia.jump.model.Rating;
import com.cognixia.jump.model.User;
import com.cognixia.jump.service.Menu;
import com.cognixia.jump.utility.Message;

public class AuthController {
		
		private User authUser = null;
		private boolean isLoggedIn = false;
		
		public AuthController() {
			this.authUser = null;
		}
		
		public boolean isLoggedIn() {
			return isLoggedIn;
		}

		public void setLoggedIn(boolean isLoggedIn) {
			this.isLoggedIn = isLoggedIn;
		}

		public void authController() {
			
		    User currentUser = null;
		    AuthController authCrtl = null;
		    try {
		     
		      authCrtl = new AuthController();
		      //Get Auth User
		      currentUser = authCrtl.login();
		      
		      // User does not Return , validate More
		      if (currentUser == null) {
		        System.out.println("User Account May Not Exist. Please Create New Account.");
		        return;
		      }
		      authCrtl.setLoggedIn(true);
		      Message.message(currentUser.getEmail() + " is logged in");
		    } catch (Exception e) {
		      System.out.print("Error out with " + e);
		    }

		    do {
		      Menu.userActionsDisplay();
		      Scanner sc2 = new Scanner(System.in);
		      Message.message("Select An Option by choosing a number: ");
		      String expression = sc2.nextLine();
		      switch (expression) {
		        case "1":
		          Message.warn("Rating A Movie ... ");
		          RatingController.rateMovie(authCrtl.getAuthUser().getUser_id());
		          break;
		        case "2":
		          Message.warn("Viewing All My Ratings ...");
		          RatingController.viewRatings(authCrtl.getAuthUser().getUser_id());
		          break;
		        case "3":
		          Message.warn("List All Movies ...");
		          MovieController.viewMovies();
		          break;
		        case "4":
		          Message.warn("Logging Out ...");
		          authCrtl.isLoggedIn = false;
		          Message.warn(" You have been logged Out.");
		          break;
		        default:
		          Message.error("This is invalid option. Quit.");
		      }
		      System.out.println("isLoggedIn is " + authCrtl.isLoggedIn);
		    } while (authCrtl.isLoggedIn);
		    
		  }
		
		public void setAuthUser(User user) {
			this.authUser = user;
		}
		
		public User getAuthUser() {
			return this.authUser;
		}
		
		public User createUser() {
			
			int id = 0;
			String name = "";
			String email = "";
			String password = "";
			List<Rating> ratings = null;
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Name: ");
			name = sc.nextLine();
			System.out.println("Enter Eamil: ");
			email = sc.nextLine();
			
			boolean isEmailValid = patternMatches(email, "^(.+)@(\\S+)$");
			if(! isEmailValid) {
				Message.error("Email is invalid.");
				return null;
			}
			System.out.println("Enter Password: ");
			password = sc.nextLine();
			
			User created = new User(id, name, email, password, ratings);
			UserDAO userDAO = new UserDAO();
			
			if(userDAO.createUser(created)) {
				this.authUser = created;
				return created;
			
			}
				
			return null;
			
		}
	
		public User login() {
			
			int id = 0;
			String name = "";
			String email = "";
			String password = "";
			List<Rating> ratings = null;
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Eamil: ");
			email = sc.nextLine();
			System.out.println("Enter Password: ");
			password = sc.nextLine();
			
			User user = new User(id, name, email, password, ratings);
			
			user.setEmail(email);
			user.setPassword(password);
			
			AuthDAO authDAO = new AuthDAO();
			try {
				user = authDAO.login(user);
				this.setAuthUser(user);
				return user;
			}catch(Error e){
				System.out.print(e);
				return null;
			}
		}
		
		public static boolean patternMatches(String emailAddress, String regexPattern) {
		    return Pattern.compile(regexPattern)
		      .matcher(emailAddress)
		      .matches();
		}
	
}
