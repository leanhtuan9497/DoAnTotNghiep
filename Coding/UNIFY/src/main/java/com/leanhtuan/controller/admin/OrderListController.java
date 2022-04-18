package com.leanhtuan.controller.admin;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.leanhtuan.model.Cart;
import com.leanhtuan.model.CartItem;
import com.leanhtuan.model.User;
import com.leanhtuan.service.CartItemService;
import com.leanhtuan.service.CartService;
import com.leanhtuan.service.UserService;
import com.leanhtuan.service.impl.CartServiceImpl;
import com.leanhtuan.service.impl.CartServiceItemImpl;
import com.leanhtuan.service.impl.UserServiceImpl;
@WebServlet(urlPatterns= {"/admin/order/list"})
public class OrderListController extends HttpServlet {
	CartItemService cartItemService=new CartServiceItemImpl();
	CartService cartService=new CartServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	List<CartItem> listCartItem =cartItemService.getAll();
	req.setAttribute("listCartItem", listCartItem);
	RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/view/list-order.jsp");
	dispatcher.forward(req, resp);
	}
	
}
