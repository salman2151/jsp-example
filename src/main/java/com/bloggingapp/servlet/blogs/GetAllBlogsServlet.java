package com.bloggingapp.servlet.blogs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloggingapp.dao.BlogDAO;
import com.bloggingapp.dto.BlogDto;


//@WebServlet("/GetAllCategoriesServlet")
@WebServlet(name="GetAllBlogsServlet" ,urlPatterns= {"/GetAllBlogsServlet"})
public class GetAllBlogsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
private BlogDAO blogDAO;
	
	public void init() {
		blogDAO = new BlogDAO();
	}
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BlogDto> listBlogDto = blogDAO.selectAllBlogDtos();
		request.setAttribute("listOfAllBlogs", listBlogDto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AllBlogs.jsp");
		dispatcher.forward(request, response);
	}

	

}
