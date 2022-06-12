<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Blog Detail</title>
<link rel="stylesheet" href="CSS/style.css">

</head>
<body>
	<div class="header">
		<h2>BLOGS Portal</h2>
		<a href="GetRecentThreeBlogsServlet" class="btn btn-success">HOME
			SCREEN</a>
		<nav class="topnav-right"></nav>
	</div>

	<div style=" display: flex; flex-direction: column; height: 85%; margin: 10px; background: white; border-radius: 10px; padding: 20px">


		<h1 style="color:#0047AB"><b>${viewBlogDto.getTitle()}</b></h1>
		
		<div style="display: flex;margin-top:10px">
		<label style="color:#0047AB"><b>Created  :</b></label> <label>${viewBlogDto.getOnCreated()}</label>
		</div>
		<div style="display: flex;margin-top:10px">
		<label style="color:#0047AB"><b>Category  :</b></label> <label>${viewBlogDto.getCategoryName()}</label>
		</div>
		
		<h5  style="margin-top:30px">${viewBlogDto.getDescription()}</h5>
		
		<h2 style="color:#0047AB;margin-top:30px"><b>Comments:</b></h2>
	</div>
</body>

</html>




