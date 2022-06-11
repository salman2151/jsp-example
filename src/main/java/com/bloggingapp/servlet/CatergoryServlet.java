package com.bloggingapp.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloggingapp.dao.CategoryDAO;
import com.bloggingapp.dto.CategoryDto;


@WebServlet("/")
public class CatergoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;
	
	public void init() {
		categoryDAO = new CategoryDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertCategoryDto(request, response);
				break;
			case "/delete":
				deleteCategoryDto(request, response);
				break;
			/*
			 * case "/edit": showEditForm(request, response); break;
			 */
			case "/update":
				updateCategoryDto(request, response);
				break;
			default:
				listCategoryDto(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listCategoryDto(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<CategoryDto> listCategoryDto = categoryDAO.selectAllCategoryDtos();
		request.setAttribute("listCategoryDto", listCategoryDto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	/*
	 * private void showEditForm(HttpServletRequest request, HttpServletResponse
	 * response) throws SQLException, ServletException, IOException { int id =
	 * Integer.parseInt(request.getParameter("id")); CategoryDto existingCategoryDto
	 * = categoryDAO.(id); RequestDispatcher dispatcher =
	 * request.getRequestDispatcher("user-form.jsp"); request.setAttribute("user",
	 * existingCategoryDto); dispatcher.forward(request, response);
	 * 
	 * }
	 */
	private void insertCategoryDto(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		CategoryDto newCategoryDto = new CategoryDto(name);
		categoryDAO.insertCategory(newCategoryDto);
		response.sendRedirect("list");
	}

	private void updateCategoryDto(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");

		CategoryDto categoryDto = new CategoryDto(id, name);
		categoryDAO.updateCategoryDto(categoryDto);
		response.sendRedirect("list");
	}

	private void deleteCategoryDto(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		categoryDAO.deleteCategoryDto(id);
		response.sendRedirect("list");

	}

}
