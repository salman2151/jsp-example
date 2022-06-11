package com.bloggingapp.dao;



import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bloggingapp.contant.Constants;
import com.bloggingapp.dto.CategoryDto;


public class CategoryDAO {


	private static final String INSERT_CATEGORY_SQL = 	"INSERT INTO category (name) VALUES "+ " (?);";

	private static final String SELECT_ALL_CATEGORIES = "select * from category";
	private static final String DELETE_CATEGORY_SQL = "delete from category where id = ?;";
	private static final String UPDATE_CATEGORY_SQL = "update category set name = ? where id = ?;";

	public CategoryDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(Constants.jdbcURL, Constants.jdbcUsername, Constants.jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertCategory(CategoryDto categoryDto) throws SQLException {
		System.out.println(INSERT_CATEGORY_SQL);
		// try-with-resource statement will auto close the connection.
		try {
			Connection connection = getConnection();
			if(connection!=null) {
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY_SQL);

				preparedStatement.setString(1, categoryDto.getName());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			}
		}catch (SQLException e) {
			printSQLException(e);
		}
	}


	public List<CategoryDto> selectAllCategoryDtos() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<CategoryDto> categoryDtos = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection connection = getConnection();
			if(connection!=null) {		// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIES);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					Date createdOn = rs.getDate("created_on");

					categoryDtos.add(new CategoryDto(id, name, createdOn));
				}
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return categoryDtos;
	}

	public boolean deleteCategoryDto(int id) throws SQLException {
		boolean rowDeleted=false;
		try {
			Connection connection = getConnection();
			if(connection!=null) {
				PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY_SQL);
				statement.setInt(1, id);
				rowDeleted = statement.executeUpdate() > 0;
			}
		}catch(Exception ex) {
			//printSQLException(ex);
		}
		return rowDeleted;
	}

	public boolean updateCategoryDto(CategoryDto categoryDto) throws SQLException {
		boolean rowUpdated=false;
		try {
			Connection connection = getConnection();
			if(connection!=null) {
				PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY_SQL);
				statement.setString(1, categoryDto.getName());
				statement.setInt(4, categoryDto.getId());

				rowUpdated = statement.executeUpdate() > 0;
			}

		}
		catch(Exception ex) {
			//printSQLException(ex);
		}
		return rowUpdated;	
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
