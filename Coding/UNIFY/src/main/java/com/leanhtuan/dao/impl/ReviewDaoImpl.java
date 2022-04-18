package com.leanhtuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.leanhtuan.dao.ReviewDao;
import com.leanhtuan.jdbc.JDBCConnection;
import com.leanhtuan.model.Review;

public class ReviewDaoImpl extends JDBCConnection implements ReviewDao {

	@Override
	public ArrayList<Review> getListReviewByProduct(int productId) {
		// TODO Auto-generated method stub
		Connection con = super.getJDBCConnection();
		String sql = "SELECT * FROM review WHERE product_id = '" + productId + "'";
        PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
	        ArrayList<Review> list = new ArrayList<>();
	        while (rs.next()) {
	            
	            Review review = new Review();
	           review.setUsername(rs.getString("username"));
	           review.setReviewID(rs.getInt("review_id"));
	           review.setProductID(rs.getInt("product_id"));
	           review.setEmail(rs.getString("email"));
	           review.setStars(rs.getInt("review_star"));
	           review.setReviewMess(rs.getString("review_message"));
	           list.add(review);
	        }
	        return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;    	
	}

	@Override
	public Review getReview(int reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertReview(Review c) {
		// TODO Auto-generated method stub
		return false;
	}

}
