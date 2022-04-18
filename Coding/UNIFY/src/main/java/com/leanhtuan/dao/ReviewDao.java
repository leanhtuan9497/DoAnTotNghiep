package com.leanhtuan.dao;

import java.util.ArrayList;

import com.leanhtuan.model.Review;

public interface ReviewDao {
	ArrayList<Review> getListReviewByProduct(int productId);
	Review getReview(int reviewId);
	boolean insertReview(Review c);
}
