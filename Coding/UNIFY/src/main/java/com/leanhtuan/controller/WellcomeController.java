package com.leanhtuan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leanhtuan.model.Product;
import com.leanhtuan.service.CategoryService;
import com.leanhtuan.service.ProductService;
import com.leanhtuan.service.impl.CategoryServiceImpl;
import com.leanhtuan.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns="/welcome")

public class WellcomeController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> productList = productService.getAll();
		req.setAttribute("pwelcome", productList);

		req.getRequestDispatcher("/view/client/view/index.jsp").forward(req, resp);
	}
	

}
