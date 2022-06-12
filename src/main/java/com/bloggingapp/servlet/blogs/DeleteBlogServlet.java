package com.bloggingapp.servlet.blogs;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloggingapp.dao.BlogDAO;


//@WebServlet("/DeleteCate")
@WebServlet(name="DeleteBlogServlet" ,urlPatterns= {"/DeleteBlogServlet"})
public class DeleteBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
private BlogDAO blogDAO;
	
	public void init() {
		blogDAO = new BlogDAO();
	}
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("blog_id"));
		try {
			blogDAO.deleteBlogDto(id);
			response.sendRedirect("GetAllBlogsServlet");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
