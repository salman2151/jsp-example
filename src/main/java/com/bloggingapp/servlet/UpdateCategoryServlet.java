package com.bloggingapp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloggingapp.dao.CategoryDAO;
import com.bloggingapp.dto.CategoryDto;

@WebServlet("/UpdateCategoryServlet") // mapper with login, as url pattern as we are not using web.xml or deployment descriptor, that why we are using @WebServlet to define Servlet
public class UpdateCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
private CategoryDAO categoryDAO;
	
	public void init() {
		categoryDAO = new CategoryDAO();
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("categoryId"));

        String categoryName = request.getParameter("categoryName");
     
        CategoryDto categoryDto = new CategoryDto(id,categoryName);
       
       // categoryDAO.insertCategory(categoryDto);
        try {
        	 categoryDAO.updateCategoryDto(categoryDto);
        	   response.sendRedirect("GetAllCategoriesServlet");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("categoryId"));
		CategoryDto categoryDto = categoryDAO.getCategoryById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateCategory.jsp");
		request.setAttribute("editableCategoryDto", categoryDto);
		dispatcher.forward(request, response);
	}

}