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
		<a href="home" class="btn btn-success">HOME SCREEN</a>
		<nav class="topnav-right"></nav>
	</div>
	
	<div
		style="display: flex; height: 85%; margin: 20px; background: white; border-radius: 10px;padding:20px">
	
			<div id="category-div"
				style=" width: 100%; height: 100%">

				<h3 style="text-align: center; padding-top: 10px">CATEGORIES</h3>
				<a href="AddNewCategory.jsp" class="btn btn-success">Add New Category</a>
				<br>
				<hr>
				
	
<table style="width:100%">
	<thead>
					<tr>
					<td><b><u>ID</u></b></th>
					<td><b><u>Name</u></b></th>
					<td><b><u>Created On</u></b></th>
					<td><b><u>Actions</u></b></th>
					</tr>
				</thead>
	<tbody>
					<c:forEach var="category" items="${listOfAllCategories}">

						<tr>
							<td><c:out value="${category.getId()}" /></td>
							<td><c:out value="${category.getName()}" /></td>
							<td><c:out value="${category.getOnCreated()}" /></td>
							<td><a href="edit?id=<c:out value='${category.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="DeleteCategoryServlet?id=<c:out value='${category.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
</table>


				
				
				
			</div>
		
		
	</div>
</body>

</html>




