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
      <h1>Add New BLOG</h1>
     <form action="<%=request.getContextPath()%>/AddNewBlogServlet" method="post">
        <div class="txt_field">
          <input name= "title" type="text" required>
          <label>Title</label>
        </div>
         <div class="txt_field">
          <input name= "description" type="text" required>
          <label>Description</label>
        </div>
      <!--    <div class="txt_field">
          <input name= "category_id" type="text" required>
          <label>CategoryId</label>
        </div> -->
        <select name="category_id" style = "width:100%;margin-bottom:40px;margin-top:5px; height:50px">
    <c:forEach var="category" items="${listOfAllCategoriesOnAddBlog}">
        <option value="${category.getId()}">${category.getName()}</option>
    </c:forEach>
</select>
        
        <input type="submit" value="Save">
    
      </form>
    </div>
</body>
</html>
