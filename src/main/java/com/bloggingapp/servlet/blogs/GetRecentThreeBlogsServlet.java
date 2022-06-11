package com.bloggingapp.servlet.blogs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloggingapp.dao.CategoryDAO;
import com.bloggingapp.dto.CategoryDto;


//@WebServlet("/GetAllCategoriesServlet")
@WebServlet(name="GetRecentThreeBlogsServlet" ,urlPatterns= {"/GetRecentThreeBlogsServlet"})
public class GetRecentThreeBlogsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
private CategoryDAO categoryDAO;
	
	public void init() {
		categoryDAO = new CategoryDAO();
	}
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CategoryDto> listCategoryDto = categoryDAO.selectAllCategoryDtos();
		request.setAttribute("listOfAllCategories", listCategoryDto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AllCategories.jsp");
		dispatcher.forward(request, response);
	}

	

}
