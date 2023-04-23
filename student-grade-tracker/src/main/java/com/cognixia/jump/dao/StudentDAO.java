package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
