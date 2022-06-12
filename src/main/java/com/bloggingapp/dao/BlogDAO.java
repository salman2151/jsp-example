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
import com.bloggingapp.dto.BlogDto;

public class BlogDAO {


	private static final String INSERT_BLOG_SQL = 	"INSERT INTO blog (category_id_fk, title, description) VALUES "+ " (?,?,?);";
	private static final String GET_BLOG_BY_ID_SQL = "SELECT blog.id, blog.title,blog.description,blog.created_on, category.id as category_id, category.name as category_name FROM blog,category WHERE category.id=blog.category_id_fk and blog.id =  ?;";
	private static final String SELECT_ALL_BLOGS = "SELECT blog.id, blog.title,blog.description,blog.created_on, category.id as category_id, category.name as category_name FROM blog,category WHERE category.id=blog.category_id_fk";
	private static final String DELETE_BLOG_SQL = "delete from blog where id = ?;";
	private static final String MOST_RECENT_3_BLOGS = "SELECT * FROM (SELECT blog.id, blog.title,blog.description,blog.created_on, category.id as category_id, category.name as category_name FROM blog,category WHERE category.id=blog.category_id_fk ORDER BY blog.id DESC LIMIT 3) t ORDER BY id DESC;";
		private static final String UPDATE_BLOG_SQL = "update blog set category_id_fk = ?, title = ?, description = ? where id = ?;";

	public BlogDAO() {
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

	public void insertBlog(BlogDto blogDto) throws SQLException {
		System.out.println(INSERT_BLOG_SQL);
		// try-with-resource statement will auto close the connection.
		try {
			Connection connection = getConnection();
			if(connection!=null) {
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BLOG_SQL);

				preparedStatement.setInt(1, blogDto.getCategoryIdFk());;
				preparedStatement.setString(2, blogDto.getTitle());
				preparedStatement.setString(3, blogDto.getDescription());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			}
		}catch (SQLException e) {
			printSQLException(e);
		}
	}


	public List<BlogDto> selectAllBlogDtos() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<BlogDto> blogDtos = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection connection = getConnection();
			if(connection!=null) {		// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BLOGS);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String description = rs.getString("description");
					Date createdOn = rs.getDate("created_on");
					int categoryId = rs.getInt("category_id");
					String categoryName = rs.getString("category_name");

					blogDtos.add(new BlogDto(id,title,description, createdOn,categoryId,categoryName));
				}
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return blogDtos;
	}

	public List<BlogDto> getRecent3Blogs() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<BlogDto> blogDtos = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection connection = getConnection();
			if(connection!=null) {		// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(MOST_RECENT_3_BLOGS);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String description = rs.getString("description");
					Date createdOn = rs.getDate("created_on");
					int categoryId = rs.getInt("category_id");
					String categoryName = rs.getString("category_name");

					blogDtos.add(new BlogDto(id,title,description, createdOn,categoryId,categoryName));
				}
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return blogDtos;
	}


	public boolean deleteBlogDto(int id) throws SQLException {
		boolean rowDeleted=false;
		try {
			Connection connection = getConnection();
			if(connection!=null) {
				PreparedStatement statement = connection.prepareStatement(DELETE_BLOG_SQL);
				statement.setInt(1, id);
				rowDeleted = statement.executeUpdate() > 0;
			}
		}catch(Exception ex) {
			//printSQLException(ex);
		}
		return rowDeleted;
	}


	public boolean updateBlogDto(BlogDto blogDto) throws SQLException { 
		boolean rowUpdated=false;
		try {
			Connection connection = getConnection();
		if(connection!=null) {
			PreparedStatement statement =
				connection.prepareStatement(UPDATE_BLOG_SQL); 
			statement.setInt(1,blogDto.getCategoryIdFk());
			statement.setString(2, blogDto.getTitle());
			statement.setString(3, blogDto.getDescription());
			statement.setInt(4, blogDto.getId());

						rowUpdated = statement.executeUpdate() > 0; }

		} catch(Exception ex) { 
			//printSQLException(ex); }
		
		}
		return rowUpdated;
	}

	public BlogDto getBlogById(int id) {
		BlogDto blogDto = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(GET_BLOG_BY_ID_SQL);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int blogId = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				Date createdOn = rs.getDate("created_on");
				int categoryId = rs.getInt("category_id");
				String categoryName = rs.getString("category_name");

				blogDto = new BlogDto(blogId,title,description, createdOn,categoryId,categoryName);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return blogDto;
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
