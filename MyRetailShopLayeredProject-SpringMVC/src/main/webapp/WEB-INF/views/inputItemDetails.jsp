<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Enter Employee Details</h1>
<spring:form action="./insertItem" modelAttribute="item">
	Enter Item ID : <spring:input path="itemId"/><br><br>
	Enter Employee Quantity : <spring:input path="quantity"/><br><br>
	<input type="submit" value="Add to Cart">
</spring:form>
<br><br>
<a href="displayItems">Go back to List of All Items</a>
</body>
</html>