package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.User;

public class UserDAO {
	
	private Connection conn = ConnectionManager.getConnection();
	
	public boolean createUser (User customer) {
		PreparedStatement pstmt = null;
		String queryStr = "INSERT INTO User(user_id, name, email, password) "
				+ "values( ?, ?, ?, ?)";
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, 0);
			pstmt.setString(2, customer.getName() );
			pstmt.setString(3,  customer.getEmail());
			pstmt.setString(4,  customer.getPassword());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
//		finally {
//			
//			try {
//				
//				pstmt.close();
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//		}
		
		return result > 0;
		
	}

}
