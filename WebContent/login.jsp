<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
 <div class="center">
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
    </div>
</body>
</html>
