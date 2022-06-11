<%@ page language="java" contentType="text/html; charset=UTF-8"
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
	<!-- 	</div> -->
</body>

</html>
