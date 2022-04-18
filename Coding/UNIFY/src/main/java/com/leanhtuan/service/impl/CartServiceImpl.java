package com.leanhtuan.service.impl;

import java.io.File;
import java.util.List;

import com.leanhtuan.dao.CartDao;
import com.leanhtuan.dao.ProductDao;
import com.leanhtuan.dao.UserDao;
import com.leanhtuan.dao.impl.CartDaoImpl;
import com.leanhtuan.dao.impl.ProductDaoImpl;
import com.leanhtuan.dao.impl.UserDaoImpl;
import com.leanhtuan.model.Cart;
import com.leanhtuan.model.Product;
import com.leanhtuan.model.User;
import com.leanhtuan.service.CartService;
import com.leanhtuan.service.ProductService;
import com.leanhtuan.service.UserService;

public class CartServiceImpl implements CartService {
	CartDao cartDao = new CartDaoImpl();

	@Override
	public List<Cart> search(String name) {
		return cartDao.search(name);
	}

	@Override
	public void insert(Cart cart) {
		cartDao.insert(cart);

	}

	@Override
	public List<Cart> getAll() {
		return cartDao.getAll();
	}

	@Override
	public Cart get(int id) {
		return cartDao.get(id);
	}

	@Override
	public void edit(Cart newCart) {
		Cart oldCart = cartDao.get(newCart.getId());

		oldCart.setBuyDate(newCart.getBuyDate());
		oldCart.setBuyer(newCart.getBuyer());
		
		
		cartDao.edit(oldCart);

	}

	@Override
	public void delete(int id) {
		cartDao.delete(id);
	}
}
