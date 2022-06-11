<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link rel="stylesheet" href="CSS/style.css">

<script type="text/javascript"> <!-- Scripts for buttons onclick listeners -->
	function onHomeButtonClick() {
		document.getElementById('post-div').style.display = 'none'
		document.getElementById('category-div').style.display = 'none'
		document.getElementById('home-div').style.display = 'block'
	}
	function onCategoryButtonClick() {
		document.getElementById('post-div').style.display = 'none'
		document.getElementById('home-div').style.display = 'none'
		document.getElementById('category-div').style.display = 'block'
	}
	function onPostButtonClick() {
		document.getElementById('category-div').style.display = 'none'
		document.getElementById('home-div').style.display = 'none'
		document.getElementById('post-div').style.display = 'block'
	}
</script>
</head>
<body>
	<div class="header">
		<h2>BLOGS Portal</h2>
		<nav class="topnav-right"></nav>
	</div>
	<div
		style="display: flex; height: 85%; margin: 20px; background: white; border-radius: 10px;">
		<div class="btn-group"
			style="width: 20%; background: #F0F0F0; padding: 15px; border-radius: 10px;">
			<!-- left div -->
			<button id="btn-home" onClick="onHomeButtonClick()">Home</button>
			<button id="btn-categories" onClick="onCategoryButtonClick()">Categories</button>
			<button id="btn-posts" onClick="onPostButtonClick()">Posts</button>
			<button onclick="location.href = 'login.jsp'"
				style="margin-top: 20px; background: #cd5c5c; border-radius: 10px;">Logout</button>
		</div>
		<!-- right div -->
		<div class="btn-group" style="width: 80%; padding: 10px">

			<div id="home-div"
				style=" width: 100%; height: 100%; background: red">

				<h3 style="text-align: center; padding-top: 15px">HOME</h3>


			</div>
			<div id="category-div"
				style="display: none; width: 100%; height: 100%; background: pink">

				<h3 style="text-align: center; padding-top: 15px">CATEGORIES</h3>
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Category</a>
				<br>
				<hr>
			</div>
			<div id="post-div"
				style="display: none; width: 100%; height: 100%; background: yellow">
				<h3 style="text-align: center; padding-top: 15px">POSTS</h3>
			</div>
		</div>
	</div>
</body>
</html>
