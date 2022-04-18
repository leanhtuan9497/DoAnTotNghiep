package com.leanhtuan.dao;

import java.util.List;

import com.leanhtuan.model.Cart;
import com.leanhtuan.model.CartItem;
import com.leanhtuan.model.Category;

public interface CartItemDao {
	void insert(CartItem cartItem);

	void edit(CartItem cartItem);

	void delete(String id);

	CartItem get(String name);

	CartItem get(int id);

	List<CartItem> getAll();

	List<CartItem> search(String name);
}
