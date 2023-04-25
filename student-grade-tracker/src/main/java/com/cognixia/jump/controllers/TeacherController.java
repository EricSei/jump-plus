package com.cognixia.jump.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.dao.EnrollementDAO;
import com.cognixia.jump.dao.SchoolClassDAO;
import com.cognixia.jump.dao.StudentDAO;
import com.cognixia.jump.dao.TeacherDAO;
import com.cognixia.jump.model.Enrollement;
import com.cognixia.jump.model.SchoolClass;
import com.cognixia.jump.model.Student;
import com.cognixia.jump.model.Teacher;
import com.cognixia.jump.service.Message;

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
	
	
	public int selectClass() {
		Message.message("Enter Class Id :");
		Scanner sc = new Scanner(System.in);
		int classId = sc.nextInt();
		
		ResultSet rs = studentDAO.getStudentsByClass(classId);
		Message.title("\tStudentId \tName \t\t Email \t\t Current Grade");
		Message.title("- - - - - - -- - - - - -- - - - - - - - - - - - -");
		try {
			while(rs.next()) {
				int enrollId = rs.getInt("id");
				int studentId = rs.getInt("student_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Double currentGrade = Math.ceil( ( rs.getInt("grade1") + rs.getInt("grade2") + rs.getInt("grade3") ) / 3.0 ) ;
				System.out.printf("| %-10s | %-10s | %-8s | %-10s %n", studentId, name, email, currentGrade.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classId;
	}
	
	public void sortClassByNames(int classId) {
		
		
		ResultSet rs = studentDAO.getStudentsByClass(classId);
		List<Student> students = new ArrayList<Student>();
		Message.title("\tStudentId \tName \t\t Email \t\t Current Grade");
		Message.title("- - - - - - -- - - - - -- - - - - - - - - - - - -");
		try {
			while(rs.next()) {
				int enrollId = rs.getInt("id");
				int studentId = rs.getInt("student_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				double currentGrade = Math.ceil( ( rs.getInt("grade1") + rs.getInt("grade2") + rs.getInt("grade3") ) / 3.0 ) ;
				Student stu = new Student();
				stu.setId(studentId);
				stu.setEmail(email);
				stu.setName(name);
				stu.setGrade(currentGrade);
				students.add(stu);
				
			}
			
			Collections.sort(students, new Comparator<Student>() {
			    @Override
			    public int compare(Student o1, Student o2) {
			       return o1.getName().compareTo( o2.getName());
			    }
			 });
			students.forEach(stu -> Message.message(" "+ stu.getId()+ "\t\t" + stu.getName() +"\t\t"+ stu.getEmail() + "\t\t"+ stu.getGrade() ));
			int average = getAverage(students);
			int median = getMedian(students);
			Message.message(" - - - - - - - - - - - - - - - - ");
			Message.message("Class Average : "+ average);
			Message.message("Class Median : "+ median);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sortClassByGrades(int classId) {
		
		ResultSet rs = studentDAO.getStudentsByClass(classId);
		List<Student> students = new ArrayList<Student>();
		Message.title("\tStudentId \tName \t\t Email \t\t Grade(Average Grade out of 3)");
		Message.title("- - - - - - -- - - - - -- - - - - - - - - - - - -");
		try {
			while(rs.next()) {
				int enrollId = rs.getInt("id");
				int studentId = rs.getInt("student_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				double currentGrade = Math.ceil( ( rs.getInt("grade1") + rs.getInt("grade2") + rs.getInt("grade3") ) / 3.0 ) ;
				Student stu = new Student();
				stu.setId(studentId);
				stu.setEmail(email);
				stu.setName(name);
				stu.setGrade(currentGrade);
				students.add(stu);
				
			}
			
			Collections.sort(students, (p1, p2) -> (int)p1.getGrade() - (int)p2.getGrade());
			students.forEach(stu -> Message.message(" "+ stu.getId()+ "\t\t" + stu.getName() +"\t\t"+ stu.getEmail() + "\t\t"+ stu.getGrade() ));
			int average = getAverage(students);
			int median = getMedian(students);
			Message.message(" - - - - - - - - - - - - - - - - ");
			Message.message("Class Average : "+ average);
			Message.message("Class Median : "+ median);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void udpateGrade(int classId) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Stdeunt Id : ");
		
		int studentId = Integer.parseInt( sc.nextLine());
		
		System.out.println("Enter Assignment Number ( grade1, grade2, grade3 ) :");
		String gradeType = sc.nextLine();
		
		System.out.println("Enter New Grade Value : ");
		int  newGradeValue = Integer.parseInt( sc.nextLine());
		
		Enrollement toUpdateEnroll = new Enrollement();
		toUpdateEnroll.setStudentId(studentId);
		toUpdateEnroll.setClassId(classId);
		enrollementDAO.updateEnrollement(toUpdateEnroll, gradeType, newGradeValue );
		
		Message.warn("Grade Has been Updated");
	}
	
	public static int getAverage(List<Student> students) {
		int total=0;
		for(Student stu: students) {
			total += stu.getGrade();
		}
		
		return total / students.size();
	}
	
	public static int getMedian(List<Student> students) {
		Collections.sort(students, (p1, p2) -> (int)p1.getGrade() - (int)p2.getGrade());
		int medianSize = students.size() / 2;
		
		
		return (int) students.get(medianSize).getGrade();
	}
	public void removeStudent(int classId) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Stdeunt Id : ");
		int studentId = Integer.parseInt( sc.nextLine());
		Enrollement toRemoveEnroll = new Enrollement();
		toRemoveEnroll.setStudentId(studentId);
		toRemoveEnroll.setClassId(classId);
		enrollementDAO.removeEnrollement(toRemoveEnroll);
		Message.message("Student Has been removed.");
	}
	
	public void addStudent(int classId) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Stdeunt Id : ");
		
		int studentId = Integer.parseInt( sc.nextLine());
		Enrollement toUpdateEnroll = new Enrollement();
		toUpdateEnroll.setStudentId(studentId);
		toUpdateEnroll.setClassId(classId);
		toUpdateEnroll.setGrade1(0);
		toUpdateEnroll.setGrade2(0);
		toUpdateEnroll.setGrade3(0);
		enrollementDAO.createEnrollement(toUpdateEnroll);
		Message.message("Student Has been added to the class.");
	}
}
