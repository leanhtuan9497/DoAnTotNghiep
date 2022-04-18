package com.leanhtuan.service.impl;

import java.io.File;
import java.util.List;

import com.leanhtuan.dao.CartDao;
import com.leanhtuan.dao.CartItemDao;
import com.leanhtuan.dao.ProductDao;
import com.leanhtuan.dao.UserDao;
import com.leanhtuan.dao.impl.CartDaoImpl;
import com.leanhtuan.dao.impl.CartItemDaoImpl;
import com.leanhtuan.dao.impl.ProductDaoImpl;
import com.leanhtuan.dao.impl.UserDaoImpl;
import com.leanhtuan.model.Cart;
import com.leanhtuan.model.CartItem;
import com.leanhtuan.model.Product;
import com.leanhtuan.model.User;
import com.leanhtuan.service.CartItemService;
import com.leanhtuan.service.CartService;
import com.leanhtuan.service.ProductService;
import com.leanhtuan.service.UserService;

public class CartServiceItemImpl implements CartItemService {
	CartItemDao cartItemDao = new CartItemDaoImpl();

	@Override
	public void insert(CartItem cartItem) {
		cartItemDao.insert(cartItem);
		
	}

	@Override
	public void edit(CartItem newCartItem) {
		CartItem oldCartItem = cartItemDao.get(newCartItem.getId());
		oldCartItem.setCart(newCartItem.getCart());
		oldCartItem.setProduct(newCartItem.getProduct());
		oldCartItem.setQuantity(newCartItem.getQuantity());
		oldCartItem.setUnitPrice(newCartItem.getUnitPrice());
		
		cartItemDao.edit(oldCartItem);
	}

	@Override
	public void delete(String id) {
		cartItemDao.delete(id);
	}

	@Override
	public CartItem get(int id) {
		return cartItemDao.get(id);
	}

	@Override
	public List<CartItem> getAll() {
		return cartItemDao.getAll();
	}

	@Override
	public List<CartItem> search(String keyword) {
		return cartItemDao.search(keyword);
	}

	
}
