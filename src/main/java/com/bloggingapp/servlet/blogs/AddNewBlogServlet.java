package com.bloggingapp.servlet.blogs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloggingapp.dao.BlogDAO;
import com.bloggingapp.dao.LoginDao;
import com.bloggingapp.dto.BlogDto;
import com.bloggingapp.dto.LoginDto;


@WebServlet("/AddNewBlogServlet") // mapper with login, as url pattern as we are not using web.xml or deployment descriptor, that why we are using @WebServlet to define Servlet
public class AddNewBlogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
private BlogDAO blogDAO;
	
	public void init() {
		blogDAO = new BlogDAO();
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    	
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("category_id"));

        
        BlogDto blogDto = new BlogDto(title,description,categoryId);
       
       // blogDAO.insertCategory(blogDto);
        try {
        	 blogDAO.insertBlog(blogDto);
        	   response.sendRedirect("GetAllBlogsServlet");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}