package com.leanhtuan.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.leanhtuan.model.Category;
import com.leanhtuan.service.CategoryService;
import com.leanhtuan.service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/edit" })
public class CategoryeEditController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Category category = cateService.get(Integer.parseInt(id));
		
		req.setAttribute("category", category);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/view/edit-category.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Category category = new Category();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

		try {
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("id")) {
					category.setId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("name")) {
					category.setName(item.getString());
					;
				}
			}
//			category.setName(name);
			cateService.edit(category);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect(req.getContextPath()+"/admin/category/list");

	}
}
