package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.model.Student;
import com.cognixia.jump.service.ConnectionManager;

public class StudentDAO {
	
	private Connection conn = ConnectionManager.getConnection();
	//create
	public boolean createStudent(Student stu) {
		
		PreparedStatement pstmt = null;
		String queryStr = "INSERT INTO Student(id, name, email, password, role) values( ?, ?, ?, ?, ? )";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, 0);
			pstmt.setString(2, stu.getName());
			pstmt.setString(3, stu.getEmail());
			pstmt.setString(4, stu.getPassword());
			pstmt.setString(5,stu.getRole());
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return result > 0;
	}
	
	public  ResultSet getStudentsByClass(int schoolClassId) {
		PreparedStatement pstmt = null;
		String queryStr = "select Enrollement.id, Enrollement.class_id, Enrollement.student_id, Enrollement.grade1, Enrollement.grade2, Enrollement.grade3, Student.email, Student.name \n"
				+ "from Enrollement\n"
				+ "left join Student on Enrollement.student_id = Student.id\n"
				+ "where class_id= ?;";
		ResultSet rs = null;
		
		int total = 0;
		double average = 0;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, schoolClassId);
			rs = pstmt.executeQuery();
			
			return rs;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
