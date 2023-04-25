package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cognixia.jump.model.Enrollement;
import com.cognixia.jump.model.SchoolClass;
import com.cognixia.jump.service.ConnectionManager;

public class EnrollementDAO {
	
	
	private Connection conn = ConnectionManager.getConnection();
	//create
	//add a student to a class
	public boolean createEnrollement(Enrollement enroll) {
		
		PreparedStatement pstmt = null;
		String queryStr = "INSERT INTO Enrollement(id, class_id, student_id, grade1, grade2, grade3 ) values( ?, ?, ?, ?, ?, ? )";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, 0);
			pstmt.setInt(2, enroll.getClassId());
			pstmt.setInt(3, enroll.getStudentId() );
			
			pstmt.setInt(4, (int) enroll.getGrade1());
			pstmt.setInt(5, (int) enroll.getGrade2());
			pstmt.setInt(6, (int) enroll.getGrade3());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return result > 0;
	}
	
	
	
	
	// remove student to a clss
	public boolean removeEnrollement(Enrollement enroll) {
		
		PreparedStatement pstmt = null;
		String queryStr = "DELETE FROM ENROLLEMENT WHERE student_id= ? AND class_id = ?";
		int result = 0;
		try {
			
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, enroll.getStudentId());
			pstmt.setInt(2, enroll.getClassId());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result > 0;
	}
			
			
	// update a student's grade
	public boolean updateEnrollement(Enrollement enroll, String gradeType, int value ) {
		PreparedStatement pstmt = null;
		String queryStr = "UPDATE ENROLLEMENT SET "+ gradeType+ " = ? WHERE student_id = ? AND class_id = ?";
		int result = 0;
		try{
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, value);
			pstmt.setInt(2, enroll.getStudentId());
			pstmt.setInt(3, enroll.getClassId());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result > 0;
		
	}
		
		
	// get average of a class
	public double getAverageGradeByClass(int schoolClassId) {
		PreparedStatement pstmt = null;
		String queryStr = "select * from Enrollement\n"
				+ "where class_id = ?";
		ResultSet rs = null;
		int total = 0;
		double average = 0;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, schoolClassId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			
				int totalGradeStudent = rs.getInt("grade1") +  rs.getInt("grade2") + rs.getInt("grade3");
				System.out.println(totalGradeStudent);
				double averageOfStudent = (double) totalGradeStudent / 3.0 ;
				average += averageOfStudent; // collect each average
				total++;
			}
			
			average = average / (double) total;  // calculate overall average
			return Math.ceil(average);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return average;
	}
	
	
	public double getAverageGrade(int schoolClassId) {
		PreparedStatement pstmt = null;
		String queryStr = "SELECT AVG(grade1 + grade2 + grade3) FROM ENROLLEMENT WHERE  class_id = ?";
		ResultSet rs = null;
		int totalGrade = 0;
		double average = 0;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, schoolClassId);
			rs = pstmt.executeQuery(queryStr);
			while(rs.next()) {
				totalGrade =rs.getInt("grade1") +  rs.getInt("grade2") + rs.getInt("grade3");
			}
			average = (double) totalGrade / (double) rs.getFetchSize();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return average;
	}
	
}
