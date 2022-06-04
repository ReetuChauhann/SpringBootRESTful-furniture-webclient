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
<h1 style="color: black; background-color: blue;">All Furniture Here!</h1>

<c:forEach items="${furniture}" var="f">
Furniture Name:<c:out value="${f.name}"></c:out><br><br>
Furniture Price:<c:out value="${f.price}"></c:out><br><br>
Furniture Type:<c:out value="${f.type}"></c:out><br><br>
<img alt="" src="getimage?name=${f.name}" height="50" width="50">
<hr>
<hr>

</c:forEach>

</body>
</html>