<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>All Blogs</title>
<link rel="stylesheet" href="CSS/style.css">

</head>
<body>

	<div class="header">
		<h2>BLOGS Portal</h2>
		<a href="GetRecentThreeBlogsServlet" class="btn btn-success">HOME SCREEN</a>
		<nav class="topnav-right"></nav>
	</div>

	<div style="display: flex; height: 85%; margin: 10px; background: white; border-radius: 10px; padding: 20px">

		<div id="blogs-div" style="width: 100%; height: 100%;overflow:auto">

			<h3 style="text-align: center; padding-top: 10px">BLOGS</h3>
			<c:if test = "${isAdminSignedIn == true}">
			<a href="AddNewBlogServlet" class="btn btn-success">Add New Blog</a>
			</c:if>
			<br>
			<hr>


			<table style="width: 100%">
				<thead>
					<tr>
						<td><b><u>ID</u></b></td>
						<td><b><u>Title</u></b></td>
						<td><b><u>Description</u></b></td>
						<td><b><u>Category</u></b></td>
						<td><b><u>Created On</u></b></td>
						<td><b><u>Actions</u></b></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="blog" items="${listOfAllBlogs}">

						<tr>
							<td><c:out value="${blog.getId()}" /></td>
							<td><c:out value="${blog.getTitle()}" /></td>
							<td><c:out value="${blog.getDescription()}" /></td>
							<td><c:out value="${blog.getCategoryName()}" /></td>
							<td><c:out value="${blog.getOnCreated()}" /></td>
							<td>
							<a href="ViewBlogServlet?blog_id=<c:out value='${blog.id}' />">View</a>
							&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="EditBlogServlet?blog_id=<c:out value='${blog.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="DeleteBlogServlet?blog_id=<c:out value='${blog.id}' />">Delete</a>
								</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>





		</div>


	</div>
</body>

</html>




