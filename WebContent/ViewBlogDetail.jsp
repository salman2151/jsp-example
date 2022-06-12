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

	<div
		style="display: flex; flex-direction: column; height: 85%; margin: 10px; background: white; border-radius: 10px; padding: 20px;; overflow: auto">


		<h1 style="color: #0047AB">
			<b>${viewBlogDto.getTitle()}</b>
		</h1>

		<div style="display: flex; margin-top: 10px">
			<label style="color: #0047AB"><b>Created :</b></label> <label>${viewBlogDto.getOnCreated()}</label>
		</div>
		<div style="display: flex; margin-top: 10px">
			<label style="color: #0047AB"><b>Category :</b></label> <label>${viewBlogDto.getCategoryName()}</label>
		</div>

		<h5 style="margin-top: 30px">${viewBlogDto.getDescription()}</h5>

		<h2 style="color: #0047AB; margin-top: 30px">
			<b>Comments:</b>
		</h2>

		<div style="height: 50%; width: 100%; overflow: auto">
			<c:forEach var="comment" items="${blogComments}">
				<div style="display: flex; margin-top: 10px">
					<label style="color: #0047AB"><b>${comment.getCommenter()}:</b></label>
					<label>${comment.getComment()}</label>
				</div>
			</c:forEach>
		</div>


		<label style="color: black; margin-top: 40px"><b><u>New
					Comment:</u></b></label>
		<form action="<%=request.getContextPath()%>/ViewBlogServlet"
			method="post">
			<div style="display: flex; margin-top: 10px">

				<div class="txt_field" style="display: none;">
					<input name="blog_id" type="text" value='${viewBlogDto.getId()}'
						required> <label>Blog Id</label>
				</div>

				<div class="txt_field" style="width: 20%">
					<input name="commenter" type="text" required> <label>Comment
						Person</label>
				</div>

				<div class="txt_field" style="width: 65%; margin-left: 30px">
					<input name="comment" type="text" required> <label>Comment</label>
				</div>

				<input type="submit"
					style="margin-top: 24px; width: 15%; margin-left: 30px"
					value="Save">


			</div>
		</form>

	</div>
</body>

</html>




