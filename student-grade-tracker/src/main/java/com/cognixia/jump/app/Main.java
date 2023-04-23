package com.cognixia.jump.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.dao.EnrollementDAO;
import com.cognixia.jump.dao.SchoolClassDAO;
import com.cognixia.jump.dao.StudentDAO;
import com.cognixia.jump.dao.TeacherDAO;
import com.cognixia.jump.model.Enrollement;
import com.cognixia.jump.model.SchoolClass;
import com.cognixia.jump.model.Student;
import com.cognixia.jump.model.Teacher;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Hello from Class Grader");
		
//		Student stu1 = new Student(0, "zawzaw", "zawzaw@gmail.com", "zawzaw@123", "student");
//		System.out.print(stu1.toString());
//		new StudentDAO().createStudent(stu1);
		
		Teacher tea1 = new Teacher(0, "Rosemary", "rosemary@gmail.com", "rosemary@1234", "teacher");
//		
//		new TeacherDAO().createTeacher(tea1);
		
		//login test
//		new TeacherDAO().login(tea1).toString();
		
		new TeacherDAO().getSchoolClasses(1).forEach( x -> System.out.println( x.toString() ) );
			
	
		
//		SchoolClass myClass = new SchoolClass(0, "ESL 100", 6);
//		new SchoolClassDAO().createSchoolClass(myClass);
		
//		new EnrollementDAO().createEnrollement( new Enrollement(0, 2, 2, "A", "N", "B" ));
		
		
		
		
		
	}

}
