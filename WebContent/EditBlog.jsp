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
      <h1>Edit BLOG</h1>
     <form action="<%=request.getContextPath()%>/EditBlogServlet" method="post">
      <div class="txt_field">
          <input name= "blog_id" type="text"  readonly="readonly" 
         value='${editableBlogDto.getId()}' 
           required>
        <!--   <label>Category Id</label> -->
        </div>
        
        <div class="txt_field">
          <input name= "title" type="text"   value='${editableBlogDto.getTitle()}'  required>
          <label>Title</label>
        </div>
         <div class="txt_field">
          <input name= "description" type="text"   value='${editableBlogDto.getDescription()}'  required>
          <label>Description</label>
        </div>
      <!--    <div class="txt_field">
          <input name= "category_id" type="text" required>
          <label>CategoryId</label>
        </div> -->
       <%--  <select name="category_id" style = "width:100%;margin-bottom:40px;margin-top:5px; height:50px">
    <c:forEach var="category" items="${listOfAllCategoriesOnEditBlog}">
       
       
       <option value="${editableBlogDto.getId()}"
    <c:if test="${category.getId() == editableBlogDto.getId()}">selected="selected"</c:if>
    >
    ${category.getName()}
</option>
       
        <option value="${category.getId()}">${category.getName()}</option>
   
   
    </c:forEach>
</select> --%>

 <select name="category_id" style = "width:100%;margin-bottom:40px;margin-top:5px; height:50px">
            <c:forEach items="${listOfAllCategoriesOnEditBlog}" var="category">
                <option value="${category.getId()}"
                    <c:if test="${category.getId() eq editableBlogDto.getId()}">
                    selected="selected"
                    </c:if>>
                    ${category.getName()}
                </option>
            </c:forEach>
        </select>
        
        <input type="submit" value="Edit">
    
      </form>
    </div>
</body>
</html>
