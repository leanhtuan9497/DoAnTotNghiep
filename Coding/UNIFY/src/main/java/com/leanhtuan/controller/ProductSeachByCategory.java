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
@WebServlet(urlPatterns="/product/category")
public class ProductSeachByCategory extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductService productService=new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate_id=req.getParameter("cate_id");
		List<Product> productSeachByCategory =productService.seachByCategory(Integer.parseInt(cate_id));
		req.setAttribute("productSeachByCategory", productSeachByCategory);
		req.getRequestDispatcher("/view/client/view/productSeachByCategory.jsp").forward(req, resp);
		
		
	}
}
