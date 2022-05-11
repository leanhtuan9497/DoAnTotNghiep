package com.leanhtuan.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.leanhtuan.model.Product;
import com.leanhtuan.service.CategoryService;
import com.leanhtuan.service.ProductService;
import com.leanhtuan.service.impl.CategoryServiceImpl;
import com.leanhtuan.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/product/list" })
public class ProductListClientController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Document doc = Jsoup.connect("https://outerity.com/").get();
		Elements pngs = doc.select("img");
		System.out.println(pngs.size());
		List<String> imgUrl = new ArrayList<String>();
		for (Element element : pngs) {
			if (!element.attr("data-src").equals("")) {
				System.out.println(element.attr("data-src"));
				imgUrl.add(element.attr("data-src"));
			}
		}
		List<Product> productList = productService.getAll();
		req.setAttribute("productList", productList);
		req.setAttribute("productCrawlList", imgUrl);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/view/product-list.jsp");
		dispatcher.forward(req, resp);
	}// cái này sai

}
