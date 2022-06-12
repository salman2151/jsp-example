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
import com.bloggingapp.dto.CommentDto;


public class CommentDAO {


	private static final String INSERT_COMMENT_SQL = 	"INSERT INTO comment (blog_id_fk, commenter,comment) VALUES "+ " (?,?,?);";
	private static final String SELECT_ALL_COMMENTS_OF_BLOG = "select * from comment where blog_id_fk = ?";

	public CommentDAO() {
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

	public void insertComment(CommentDto commentDto) throws SQLException {
		System.out.println(INSERT_COMMENT_SQL);
		// try-with-resource statement will auto close the connection.
		try {
			Connection connection = getConnection();
			if(connection!=null) {
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMMENT_SQL);

				preparedStatement.setInt(1, commentDto.getBlogIdFk());
				preparedStatement.setString(2, commentDto.getCommenter());
				preparedStatement.setString(3, commentDto.getComment());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			}
		}catch (SQLException e) {
			printSQLException(e);
		}
	}


	public List<CommentDto> selectAllCommentDtos(int blogIdFK) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<CommentDto> commentDtos = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection connection = getConnection();
			if(connection!=null) {		// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMMENTS_OF_BLOG);
				preparedStatement.setInt(1, blogIdFK);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int id = rs.getInt("id");
					int blogIdFk = rs.getInt("blog_id_fk");
					String commenter = rs.getString("commenter");
					String comment = rs.getString("comment");
					Date createdOn = rs.getDate("created_on");

					commentDtos.add(new CommentDto(id,blogIdFk,commenter,comment, createdOn));
				}
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return commentDtos;
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
