package com.cognixia.jump.controllers;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.cognixia.jump.dao.TeacherDAO;
import com.cognixia.jump.model.Teacher;
import com.cognixia.jump.service.Menu;
import com.cognixia.jump.service.Message;

public class AuthController {
	private Teacher authUser = null;
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
		
		Teacher currentUser = null;
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
	      Menu.classActionsDisplay();;
	      Scanner sc2 = new Scanner(System.in);
	      Message.message("Select An Option by choosing a number: ");
	      String expression = sc2.nextLine();
	      switch (expression) {
	        case "1":
	          Message.warn("Create A Class...");
	         
	          break;
	        case "2":
	          Message.warn("View A Class...");
	          break;
	        case "3":
	          Message.warn("List All Your Classes...");
	        case "4":
		          Message.warn("Find Average and Median for a class...");
	        case "5":
		          Message.warn("Sort Classes By Names...");
	        case "6":
		          Message.warn("Sort Classes By Grade...");
	          break;
	        case "7":
		          Message.warn("Update A Grade...");
	        case "8":
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
	
	
	
	public Teacher createTeacher() {
		
		int id = 0;
		String name = "";
		String email = "";
		String password = "";
		
		
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
		
		Teacher created = new Teacher(id, name, email, password, "teacher");
		TeacherDAO teacherDAO = new TeacherDAO();
		
		if(teacherDAO.createTeacher(created)) {
			this.authUser = created;
			return created;
		}
		return null;
	}

	public Teacher login() {
		
		int id = 0;
		String name = "";
		String email = "";
		String password = "";
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Eamil: ");
		email = sc.nextLine();
		System.out.println("Enter Password: ");
		password = sc.nextLine();
		
		Teacher teacher = new Teacher(id, name, email, password, "teacher");
		
		teacher.setEmail(email);
		teacher.setPassword(password);
		TeacherDAO teacherDAO = new TeacherDAO();
		
		try {
			teacher = teacherDAO.login(teacher);
			this.authUser = teacher;
			return teacher;
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
