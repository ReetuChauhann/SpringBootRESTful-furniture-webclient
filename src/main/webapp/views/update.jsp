<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color: black; background-color: blue;">Update Furniture Here!</h1>
<p style="color: black; background-color: blue;">${sts}</p>
<hr>
<hr>
<form action="updatehere" method="post" enctype="multipart/form-data">
Select Name Of the Food Which You want to update<select name="name">
<c:forEach items="${allname}" var="n">
<option>${n}</option>
</c:forEach>
</select><br><br>
Update Price: <input type="number" name="price" required="required"/><br><br>
Update Type: <input type="text" name="type" required="required"/><br><br>
Update Image: <input type="file" name="image"/><br><br>
                   <button>Update</button>
</form>
<hr>
<hr>

</body>
</html>