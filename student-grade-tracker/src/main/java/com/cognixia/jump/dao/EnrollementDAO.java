package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cognixia.jump.model.Enrollement;
import com.cognixia.jump.model.SchoolClass;
import com.cognixia.jump.service.ConnectionManager;

public class EnrollementDAO {
	
	
	private Connection conn = ConnectionManager.getConnection();
	//create
	public boolean createEnrollement(Enrollement enroll) {
		
		PreparedStatement pstmt = null;
		String queryStr = "INSERT INTO Enrollement(id, class_id, student_id, grade1, grade2, grade3 ) values( ?, ?, ?, ?, ?, ? )";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, 0);
			pstmt.setInt(2, enroll.getClassId());
			pstmt.setInt(3, enroll.getStudentId() );
			
			pstmt.setString(4, enroll.getGrade1());
			pstmt.setString(5, enroll.getGrade2());
			pstmt.setString(6, enroll.getGrade3());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return result > 0;
	}
	
}
