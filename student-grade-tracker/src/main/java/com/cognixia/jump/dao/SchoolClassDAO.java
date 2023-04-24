package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.cognixia.jump.model.SchoolClass;
import com.cognixia.jump.service.ConnectionManager;

public class SchoolClassDAO {
	
	private Connection conn = ConnectionManager.getConnection();
	//create
	public boolean createSchoolClass(SchoolClass schoolCl) {
		
		PreparedStatement pstmt = null;
		String queryStr = "INSERT INTO Class(id, name, teacher_id) values( ?, ?, ? )";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, 0);
			pstmt.setString(2, schoolCl.getName());
			pstmt.setInt(3, schoolCl.getTeacherId());
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return result > 0;
	}
	
	
	
	
	
	
}
