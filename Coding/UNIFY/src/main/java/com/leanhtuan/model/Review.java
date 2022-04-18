package com.leanhtuan.model;

public class Review {
	private int reviewID;
	private String username;
	private String email;
	private int productID;
	private int stars;
	private String reviewMess;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Review(int reviewID, String username, String email, int productID, int stars, String reviewMess) {
		super();
		this.reviewID = reviewID;
		this.username = username;
		this.email = email;
		this.productID = productID;
		this.stars = stars;
		this.reviewMess = reviewMess;
	}

	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public String getReviewMess() {
		return reviewMess;
	}
	public void setReviewMess(String reviewMess) {
		this.reviewMess = reviewMess;
	}
	
}
