<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Update Category</title>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
 <div class="center">
      <h1>Update Category</h1>
     <form action="<%=request.getContextPath()%>/UpdateCategoryServlet" method="post">
       <div class="txt_field">
          <input name= "categoryId" type="text"  readonly="readonly" 
         value='${editableCategoryDto.getId()}' 
           required>
        <!--   <label>Category Id</label> -->
        </div>
        
   <div class="txt_field">
          <input name= "categoryName" type="text"
         value='${editableCategoryDto.getName()}' 
           required>
          <label>Category Name</label>
        </div>
        
     
        
        <input type="submit" value="Edit">
    
      </form>
    </div>
</body>
</html>


