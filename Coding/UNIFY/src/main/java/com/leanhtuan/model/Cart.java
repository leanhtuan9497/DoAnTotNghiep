package com.leanhtuan.model;

import java.io.Serializable;
import java.sql.Date;

public class Cart implements Serializable {
	private String id;
	private User buyer;
	private Date buyDate;
	private float total_amount;

	public Cart() {
		super();
	}

	public Cart(String id, User buyer, Date buyDate, float total_amount) {
		super();
		this.id = id;
		this.buyer = buyer;
		this.buyDate = buyDate;
		this.total_amount = total_amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public float getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", buyer=" + buyer + ", buyDate=" + buyDate + ", total_amount=" + total_amount + "]";
	}
	
	

}
