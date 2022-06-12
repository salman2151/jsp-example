<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>New Category</title>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
 <div class="center">
      <h1>Add New Category</h1>
      		<table style="width: 100%">
				<thead>
					<tr>
						<td><b><u>ID</u></b>
						</th>
						<td><b><u>Name</u></b>
						</th>
						<td><b><u>Created On</u></b>
						</th>
						<td><b><u>Actions</u></b>
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="category" items="${listOfAllCategories}">

						<tr>
							<td><c:out value="${category.getId()}" /></td>
							<td><c:out value="${category.getName()}" /></td>
							<td><c:out value="${category.getOnCreated()}" /></td>
							<td><a
								href="UpdateCategory.jsp?id=<c:out value='${category.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="DeleteCategoryServlet?id=<c:out value='${category.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
      
    
    </div>
</body>
</html>
