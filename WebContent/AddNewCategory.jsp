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
      <h1>Add New Category</h1>
     <form action="<%=request.getContextPath()%>/AddNewCategoryServlet" method="post">
        <div class="txt_field">
          <input name= "categoryName" type="text" required>
          <label>Category Name</label>
        </div>
        
        <input type="submit" value="Save">
    
      </form>
    </div>
</body>
</html>
