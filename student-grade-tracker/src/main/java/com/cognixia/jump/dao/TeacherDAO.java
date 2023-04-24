package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cognixia.jump.model.SchoolClass;
import com.cognixia.jump.model.Teacher;
import com.cognixia.jump.service.ConnectionManager;

public class TeacherDAO {
	
	private Connection conn = ConnectionManager.getConnection();
	
	//create a register
	public boolean createTeacher(Teacher teacher) {
		
		PreparedStatement pstmt = null;
		String queryStr = "INSERT INTO Teacher(id, name, email, password, role) values( ?, ?, ?, ?, ? )";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, 0);
			pstmt.setString(2, teacher.getName());
			pstmt.setString(3, teacher.getEmail());
			pstmt.setString(4, teacher.getPassword());
			pstmt.setString(5,teacher.getRole());
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return result > 0;
	}
	
	//logion teacher
	public Teacher login(Teacher teacher) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "Select id, email, password from Teacher where Teacher.email = ? ";
		
		int storedId = -1;
		String storedEmail = null;
		String storedPassword = null;
		//query customer with email and check password
		try {
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, teacher.getEmail());
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()) {
				 storedId = rs.getInt("id");
				 storedEmail = rs.getString("email");
				 storedPassword = rs.getString("password");
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean isExist =  teacher.getEmail().equals(storedEmail) && 
				teacher.getPassword().equals(storedPassword);
		if(isExist) {
			teacher.setId(storedId);
			System.out.print(teacher.toString());
			return teacher;
		}
		
		return null;
	}
	
	//get classes taught by a teacher
	public List<SchoolClass> getSchoolClasses(int teacherId){
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<SchoolClass> list = new ArrayList<>();
		String queryStr = "SELECT * FROM Class WHERE teacher_id = ?";
		
		try {
			pstm = conn.prepareStatement(queryStr);
			pstm.setInt(1, teacherId);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				list.add(new SchoolClass(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getInt("teacher_id")
				));
				
			}
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
}
