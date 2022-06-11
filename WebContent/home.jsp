<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link rel="stylesheet" href="CSS/style.css">

</head>
<body>
	<div class="header">
		<h2>BLOGS Portal</h2>
		<nav class="topnav-right"></nav>
	</div>
	<div style="display: flex; height: 87.5%; margin: 10px; background: white; border-radius: 10px; padding: 10px">
		<div class="btn-group"
			style="width: 20%; background: #F0F0F0; padding: 15px; border-radius: 10px;">
						<button id="btn-categories" onclick="location.href = 'GetAllCategoriesServlet'">CRUD
				Categories</button>
			<button id="btn-posts" onclick="location.href = 'GetAllBlogsServlet'">CRUD
				Posts</button>
			<button onclick="location.href = 'login.jsp'"
				style="margin-top: 20px; background: #cd5c5c; border-radius: 10px;">Logout</button>
		</div>
		<!-- right div -->
		<div class="btn-group" style="width: 80%; padding: 10px">

			<div id="blogs-div" style="width: 100%; height: 100%">

			<h3 style="text-align: center; padding-top: 10px">Recent 3 Blogs</h3>
	
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
					<!-- 	<td><b><u>Actions</u></b></td> -->
					</tr>
				</thead>
				<tbody>
					<c:forEach var="blog" items="${recent3Blogs}">

						<tr>
							<td><c:out value="${blog.getId()}" /></td>
							<td><c:out value="${blog.getTitle()}" /></td>
							<td><c:out value="${blog.getDescription()}" /></td>
							<td><c:out value="${blog.getCategoryName()}" /></td>
							<td><c:out value="${blog.getOnCreated()}" /></td>
						<%-- 	<td><a
								href="UpdateBlog.jsp?id=<c:out value='${blog.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="DeleteBlogServlet?id=<c:out value='${blog.id}' />">Delete</a></td>
					 --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>





		</div>

			
		</div>
	</div>
</body>
</html>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<link rel="stylesheet" href="CSS/style.css">


</head>
<body>
	<div class="header">
		<h2>BLOGS Portal</h2>
		<nav class="topnav-right"></nav>
	</div>

	<div class=center>
		<div class="btn-group"
			style="width: 100%; background: #F0F0F0; padding: 15px; border-radius: 10px;">
			<button id="btn-categories" onclick="location.href = 'GetAllCategoriesServlet'">CRUD
				Categories</button>
			<button id="btn-posts" onclick="location.href = 'GetAllBlogsServlet'">CRUD
				Posts</button>
			<button onclick="location.href = 'login.jsp'"
				style="margin-top: 20px; background: #cd5c5c; border-radius: 10px;">Logout</button>
		</div>
	</div>
</body>

</html>
 --%>