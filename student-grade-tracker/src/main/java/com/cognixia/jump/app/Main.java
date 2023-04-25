package com.cognixia.jump.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.controllers.AuthController;
import com.cognixia.jump.dao.EnrollementDAO;
import com.cognixia.jump.dao.SchoolClassDAO;
import com.cognixia.jump.dao.StudentDAO;
import com.cognixia.jump.dao.TeacherDAO;
import com.cognixia.jump.model.Enrollement;
import com.cognixia.jump.model.SchoolClass;
import com.cognixia.jump.model.Student;
import com.cognixia.jump.model.Teacher;
import com.cognixia.jump.service.Menu;
import com.cognixia.jump.service.Message;

public class Main {
	
	public static void main(String[] args) {
		
	 Message.title("Hello from Class Grader");
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
	          auth.createTeacher();
	          break;
	        case "3":
	          sc.close();
	          isQuit = true;
	          Message.message("Quit. Thanks for Grade Book. Bye.");
	          break;
	        default:
	          Message.error("This is invalid option. Pick 1, 2, 3.");
	      }
	    } while (!isQuit);
	}

}
