package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Movie;
import com.cognixia.jump.model.Rating;

public class RatingDAO {
	private Connection conn = ConnectionManager.getConnection();
	
	public boolean createRating(Rating rating) {
		PreparedStatement pstmt = null;
		String queryStr = "INSERT INTO RATING(id, user_id, movie_id, score) "
				+ "values( ?, ?, ?, ?)";
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, 0);
			pstmt.setInt(2, rating.getUserId());
			pstmt.setInt(3,rating.getMovieId());
			pstmt.setInt(4,rating.getScore());
			
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
	
	public List<Rating> ratingsByUser(int userId){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Rating> ratings = new ArrayList<>();
		String query = "SELECT * from rating\r\n"
				+ "WHERE user_id = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Rating rating = new Rating(
				rs.getInt("id"),
				rs.getInt("user_id"),
				rs.getInt("movie_id"),
				rs.getInt("score"));
				ratings.add(rating);
			}
		}catch(SQLException e) {
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
		return ratings;
	}
}
