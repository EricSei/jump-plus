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
		          Message.message("Quit. Thanks for using Movie Ratings. Bye.");
		          break;
		        default:
		          Message.error("This is invalid option. Pick 1, 2, 3.");
		      }
		    } while (!isQuit);
		  
		
//		Student stu1 = new Student(0, "zawzaw", "zawzaw@gmail.com", "zawzaw@123", "student");
//		System.out.print(stu1.toString());
//		new StudentDAO().createStudent(stu1);
		
		Teacher tea1 = new Teacher(0, "Rosemary", "rosemary@gmail.com", "rosemary@1234", "teacher");
//		
//		new TeacherDAO().createTeacher(tea1);
		
		//login test
//		new TeacherDAO().login(tea1).toString();
		
//		new TeacherDAO().getSchoolClasses(1).forEach( x -> System.out.println( x.toString() ) );
			
	
		
//		SchoolClass myClass = new SchoolClass(0, "ESL 100", 6);
//		new SchoolClassDAO().createSchoolClass(myClass);
		
//		new EnrollementDAO().createEnrollement( new Enrollement(0, 2, 2, "A", "N", "B" ));
		
		
		// remove enrollement
//		Enrollement toRemoveEnroll = new Enrollement();
//		toRemoveEnroll.setStudentId(2);
//		toRemoveEnroll.setClassId(1);
//		new EnrollementDAO().removeEnrollement(toRemoveEnroll);
		
		//udpate a grade
//		Enrollement toRemoveEnroll = new Enrollement();
//		toRemoveEnroll.setStudentId(3);
//		toRemoveEnroll.setClassId(1);
//		
//		new EnrollementDAO().updateEnrollement(toRemoveEnroll, "grade3", 35 );
		
//		double average = new EnrollementDAO().getAverageGradeByClass(2);
//		System.out.println(average);
		
	}

}
