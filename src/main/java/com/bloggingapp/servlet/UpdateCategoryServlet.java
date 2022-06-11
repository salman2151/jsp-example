package com.bloggingapp.servlet;

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

import com.bloggingapp.dao.CategoryDAO;
import com.bloggingapp.dao.LoginDao;
import com.bloggingapp.dto.CategoryDto;
import com.bloggingapp.dto.LoginDto;

import net.javaguides.usermanagement.model.User;


@WebServlet("/UpdateCategoryServlet") // mapper with login, as url pattern as we are not using web.xml or deployment descriptor, that why we are using @WebServlet to define Servlet
public class UpdateCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
private CategoryDAO categoryDAO;
	
	public void init() {
		categoryDAO = new CategoryDAO();
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        String categoryName = request.getParameter("categoryName");
     
        CategoryDto categoryDto = new CategoryDto(categoryId,categoryName);
       
       // categoryDAO.insertCategory(categoryDto);
        try {
        	 categoryDAO.insertCategory(categoryDto);
        	   response.sendRedirect("GetAllCategoriesServlet");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CategoryDto categoryDto = categoryDAO.getCategoryById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("editableCategoryDto", categoryDto);
		dispatcher.forward(request, response);
	}

}