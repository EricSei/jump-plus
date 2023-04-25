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
	
	private int classIdPicked = 0;
	private int studentIdPicked = 0;
	
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
	    TeacherController teacherController = null;
	    
	    
	    try {
	     
	      authCrtl = new AuthController();
	      currentUser = authCrtl.login();
	      
	      // User does not Return , validate More
	      if (currentUser == null) {
	        System.out.println("User Account May Not Exist. Please Create New Account.");
	        return;
	      }
	      teacherController = new TeacherController(currentUser);
	      authCrtl.setLoggedIn(true);
	      Message.message(currentUser.getEmail() + " is logged in");
	    } catch (Exception e) {
	      System.out.print("Error out with " + e);
	    }
	    
	  
	   

	    do {
    	  Message.warn(" --- All Your Classes ---");
    	  teacherController.viewClasses();
	      Menu.classActionsDisplay();;
	      Scanner sc2 = new Scanner(System.in);
	      Message.message("Select An Option by choosing a number: ");
	      String expression = sc2.nextLine();
	      switch (expression) {
	        case "1":
	        	Message.warn("--- Create A Class --- ");
	        	teacherController.createClass();
	        	break;
	        case "2":
	        	Message.warn(" --- View A Class --- "); // display students with a clas, Message.warn("Find Average and Median for a class");
	        	classIdPicked = teacherController.selectClass();
	          break;
	        case "0":
	        	Message.warn("Logging Out ...");
	        	authCrtl.isLoggedIn = false;
        	Message.warn(" You have been logged Out.");
        		break;
	        default:
	          Message.error("This is invalid option. Quit.");
	      }
	      
	      
	      do {
		      Menu.studentsByClassActions(); //students actions display
		      Scanner sc3 = new Scanner(System.in);
		      Message.message("Select An Option by choosing a number: ");
		      String expression3 = sc3.nextLine();
		      switch (expression3) {   
		        case "1":
		        	Message.warn(" --- Sort Stduents By Names --- ");
		        	teacherController.sortClassByNames(classIdPicked);
		        	break;
		        case "2":
		        	Message.warn(" --- Sort Students By Grade --- ");
		        	teacherController.sortClassByGrades(classIdPicked);
		        	break;
		        case "3":
		        	Message.warn("  --- Update A Grade ----  ");
		        	teacherController.udpateGrade(classIdPicked);
		        	break;
		        case "4":
		        	Message.warn(" --- Remove A Student from the class ---- ");
		        	teacherController.removeStudent(classIdPicked);
		        	break;
		        case "5":
		        	Message.warn("--- Add a Student to the class ---- ");
		        	teacherController.addStudent(classIdPicked);
		        	break;
		        case "6":
		        	Message.warn(" --- Go Back to View Classes ---- ");
		        	classIdPicked = 0;
		        	break;
		        case "0":
		        	Message.warn(" --- Logging Out --- ");
		        	authCrtl.isLoggedIn = false;
		        	Message.warn(" You have been logged Out.");
	        		break;
		        default:
		          Message.error("This is invalid option. Quit.");
		      }
		 
		    } while (authCrtl.isLoggedIn &&  classIdPicked > 0);    
	
	 
	    } while (authCrtl.isLoggedIn &&  classIdPicked == 0);    
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
