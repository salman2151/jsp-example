<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">

function passDetails() {
     
        window.location.href = "GetRecentThreeBlogsServlet";
}
</script>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link rel="stylesheet" href="CSS/style.css">


</head>
<body>
 <div class="center" style="padding-bottom:30px" >
      <h1>Blog Login</h1>
     <form action="<%=request.getContextPath()%>/login" method="post">
        <div class="txt_field">
          <input name= "email" type="text" required>
          <label>Email</label>
        </div>
        <div class="txt_field">
          <input  name="password" type="password" required>
          <label>Password</label>
        </div>
        <div class="pass">Forgot Password?</div>
        <input type="submit" value="Login">

    
      </form>
<div class="btn-group"
			style="width: 100%">
			<button id="btn-posts" onclick="location.href = 'GetRecentThreeBlogsServlet'">CRUD
				Skip for Bloggers</button>
		</div>
  
    </div>
</body>
</html>
