package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.User;

public class AuthDAO {
	
	private Connection conn = ConnectionManager.getConnection();
	
	
	public User login(User user) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "Select user_id, email, password from user \r\n"
				+ "    where user.email = ? ";
		
		int storedId = -1;
		String storedEmail = null;
		String storedPassword = null;
		//query customer with email and check password
		try {
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, user.getEmail());
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()) {
				 storedId = rs.getInt("user_id");
				 storedEmail = rs.getString("email");
				 storedPassword = rs.getString("password");
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean isExist =  user.getEmail().equals(storedEmail) && 
				user.getPassword().equals(storedPassword);
		if(isExist) {
			user.setUser_id(storedId);
			System.out.print(user.toString());
			return user;
		}
		
		return null;
	}
	
	
	
	
	public boolean logout() {
		return true;
	}
}
