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

public class MovieDAO {
	private Connection conn = ConnectionManager.getConnection();
	
	public boolean createMovie(Movie movie) {
		PreparedStatement pstmt = null;
		String queryStr = "INSERT INTO Movie(id, name) "
				+ "values( ?, ?)";
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, 0);
			pstmt.setString(2, movie.getName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
//		finally {
//			
//			try {
//				pstmt.close();
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//		}
		
		return result > 0;
	}
	
	public List<Movie> getMovies() {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Movie> movieList = new ArrayList<Movie>();
		String query = "SELECT * from movie";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Movie movie = new Movie(
				rs.getInt("id"),
				rs.getString("name"));
				movieList.add(movie);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
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
		return movieList;
	}
}
