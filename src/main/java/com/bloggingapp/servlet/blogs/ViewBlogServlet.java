package com.bloggingapp.servlet.blogs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloggingapp.dao.BlogDAO;
import com.bloggingapp.dao.CategoryDAO;
import com.bloggingapp.dao.CommentDAO;
import com.bloggingapp.dao.LoginDao;
import com.bloggingapp.dto.BlogDto;
import com.bloggingapp.dto.CategoryDto;
import com.bloggingapp.dto.CommentDto;
import com.bloggingapp.dto.LoginDto;


@WebServlet("/ViewBlogServlet") // mapper with login, as url pattern as we are not using web.xml or deployment descriptor, that why we are using @WebServlet to define Servlet
public class ViewBlogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
//private BlogDAO blogDAO;
private CommentDAO commentDao;

	public void init() {
		
		commentDao = new CommentDAO();
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

    throws ServletException, IOException {
    	
    	  int blogIdFk = Integer.parseInt(request.getParameter("blog_id"));
        String commenter = request.getParameter("commenter");
        String comment = request.getParameter("comment"); 
        CommentDto commentDto = new CommentDto(blogIdFk,commenter,comment);
       
        try {
        	 commentDao.insertComment(commentDto);
        	   response.sendRedirect("ViewBlogServlet?blog_id="+blogIdFk);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		int id = Integer.parseInt(request.getParameter("blog_id"));
	
		BlogDto blogDto = new BlogDAO().getBlogById(id);		
	
		request.setAttribute("viewBlogDto", blogDto);
		request.setAttribute("blogComments", commentDao.selectAllCommentDtos(id));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewBlogDetail.jsp");
		dispatcher.forward(request, response);
	}
}