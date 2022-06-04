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
<h1 style="color: black; background-color: blue;">Furniture Website</h1>
<hr>
<hr>
<h1 style="color: black; background-color: blue;">Add Furniture Here!</h1>
<p style="color: black; background-color: blue;">${status}</p>

<form action="addfurniture" method="post" enctype="multipart/form-data">
Name: <input type="text" name="name" placeholder="Enter the name plz" required/><br><br>
Price: <input type="number" name="price" placeholder="Enter the price" required/><br><br>
Type: <input type="text" name="type" placeholder="Enter the type plz" required/><br><br>
Upload Image: <input type="file" name="image"/><br><br>
             <button>Add</button>
</form>
<hr>
<hr>
<a href="update">Click here to update!</a>
<hr>
<hr>
<a href="viewall">Click here to view all</a>
<hr>
<hr>

</body>
</html>