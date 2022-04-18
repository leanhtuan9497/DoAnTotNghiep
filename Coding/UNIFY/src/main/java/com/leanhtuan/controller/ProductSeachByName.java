package com.leanhtuan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leanhtuan.model.Product;
import com.leanhtuan.service.ProductService;
import com.leanhtuan.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns="/product/seach")
public class ProductSeachByName extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductService productService=new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		List<Product> productSeachByName =productService.seachByName(name);
		req.setAttribute("productSeachByName", productSeachByName);
		req.getRequestDispatcher("/view/client/view/product-seach-by-name.jsp").forward(req, resp);
		
		
	}
}
