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
import com.bloggingapp.dao.LoginDao;
import com.bloggingapp.dto.BlogDto;
import com.bloggingapp.dto.CategoryDto;
import com.bloggingapp.dto.LoginDto;


@WebServlet("/EditBlogServlet") // mapper with login, as url pattern as we are not using web.xml or deployment descriptor, that why we are using @WebServlet to define Servlet
public class EditBlogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
private BlogDAO blogDAO;
private CategoryDAO categoryDAO;

	public void init() {
		blogDAO = new BlogDAO();
		categoryDAO = new CategoryDAO();
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

    throws ServletException, IOException {

    	int blogId = Integer.parseInt(request.getParameter("blog_id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("category_id"));

        
        BlogDto blogDto = new BlogDto(blogId,title,description,categoryId);
       
       // blogDAO.insertCategory(blogDto);
        try {
        	 blogDAO.updateBlogDto(blogDto);
        	   response.sendRedirect("GetAllBlogsServlet");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("blog_id"));
		BlogDto blogDto = blogDAO.getBlogById(id);		
		List<CategoryDto> listCategoryDto = categoryDAO.selectAllCategoryDtos();
		request.setAttribute("editableBlogDto", blogDto);
		request.setAttribute("listOfAllCategoriesOnEditBlog", listCategoryDto);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("EditBlog.jsp");
		dispatcher.forward(request, response);
	}
}