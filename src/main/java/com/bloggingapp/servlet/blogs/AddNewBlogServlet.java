package com.bloggingapp.servlet.blogs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloggingapp.dao.CategoryDAO;
import com.bloggingapp.dao.LoginDao;
import com.bloggingapp.dto.CategoryDto;
import com.bloggingapp.dto.LoginDto;


@WebServlet("/AddNewBlogServlet") // mapper with login, as url pattern as we are not using web.xml or deployment descriptor, that why we are using @WebServlet to define Servlet
public class AddNewBlogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
private CategoryDAO categoryDAO;
	
	public void init() {
		categoryDAO = new CategoryDAO();
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String categoryName = request.getParameter("categoryName");
     
        CategoryDto categoryDto = new CategoryDto(categoryName);
       
       // categoryDAO.insertCategory(categoryDto);
        try {
        	 categoryDAO.insertCategory(categoryDto);
        	   response.sendRedirect("GetAllCategoriesServlet");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}