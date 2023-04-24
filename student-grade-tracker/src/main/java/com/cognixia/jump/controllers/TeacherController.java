package com.cognixia.jump.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.dao.EnrollementDAO;
import com.cognixia.jump.dao.SchoolClassDAO;
import com.cognixia.jump.dao.StudentDAO;
import com.cognixia.jump.dao.TeacherDAO;
import com.cognixia.jump.model.SchoolClass;
import com.cognixia.jump.model.Teacher;
import com.cognixia.jump.service.Message;


//Student stu1 = new Student(0, "zawzaw", "zawzaw@gmail.com", "zawzaw@123", "student");
//System.out.print(stu1.toString());
//new StudentDAO().createStudent(stu1);

//Teacher tea1 = new Teacher(0, "Rosemary", "rosemary@gmail.com", "rosemary@1234", "teacher");
//
//new TeacherDAO().createTeacher(tea1);

//login test
//new TeacherDAO().login(tea1).toString();

//new TeacherDAO().getSchoolClasses(1).forEach( x -> System.out.println( x.toString() ) );
	


//SchoolClass myClass = new SchoolClass(0, "ESL 100", 6);
//new SchoolClassDAO().createSchoolClass(myClass);

//new EnrollementDAO().createEnrollement( new Enrollement(0, 2, 2, "A", "N", "B" ));


// remove enrollement
//Enrollement toRemoveEnroll = new Enrollement();
//toRemoveEnroll.setStudentId(2);
//toRemoveEnroll.setClassId(1);
//new EnrollementDAO().removeEnrollement(toRemoveEnroll);

//udpate a grade
//Enrollement toRemoveEnroll = new Enrollement();
//toRemoveEnroll.setStudentId(3);
//toRemoveEnroll.setClassId(1);
//
//new EnrollementDAO().updateEnrollement(toRemoveEnroll, "grade3", 35 );

//double average = new EnrollementDAO().getAverageGradeByClass(2);
//System.out.println(average);

public class TeacherController {
	
	TeacherDAO teacherDAO = new TeacherDAO();
    SchoolClassDAO schoolClassDAO = new SchoolClassDAO();
    EnrollementDAO enrollementDAO = new EnrollementDAO();
    StudentDAO studentDAO = new StudentDAO();
    private Teacher currentTeacher = null;
    
    public TeacherController() {
  
    }
    
    public TeacherController(Teacher teacher) {
    	this.currentTeacher = teacher;
    }
    
	
	public void createClass() {
		Message.message("Enter Class Name :");
		Scanner sc = new Scanner(System.in);
		String className = sc.nextLine();
		SchoolClass myClass = new SchoolClass(0 , className, this.currentTeacher.getId());
		schoolClassDAO.createSchoolClass(myClass);
	}
	
	public void viewClasses() {
		List<SchoolClass> schoolClasses = teacherDAO.getSchoolClasses(this.currentTeacher.getId());
		Message.title("Class Id      Class Name");
		schoolClasses.forEach(x -> Message.message(x.getId() + " "+  x.getName() ));
		
	}
	
	//return all students, show median and average
	public void selectClass() {
		Message.message("Enter Class Id :");
		Scanner sc = new Scanner(System.in);
		int classId = sc.nextInt();
		
		ResultSet rs = studentDAO.getStudentsByClass(classId);
		Message.title("\tName \t\t Email \t\t Current Grade");
		Message.title("- - - - - - -- - - - - -- - - - - - - - - - - - -");
		try {
			while(rs.next()) {
				int enrollId = rs.getInt("id");
				int studentId = rs.getInt("student_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				double currentGrade = Math.ceil( ( rs.getInt("grade1") + rs.getInt("grade2") + rs.getInt("grade3") ) / 3.0 ) ;
				Message.message(" "+name +"\t\t"+ email + "\t\t"+ currentGrade);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void sortClassByNames(int classId) {
		
	}
	
	public static void sortClassByGrades(int classId) {
		
	}
	
	public static void removeStudent(int studentId) {
		
	}
	
	public static void addStudent(int studentId) {
		
	}
	
	

}
