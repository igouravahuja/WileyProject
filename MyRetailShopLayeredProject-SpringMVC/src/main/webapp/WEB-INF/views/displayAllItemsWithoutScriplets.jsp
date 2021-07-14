<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Items Available at our Store</h1>
	<table border="1">
		<tr>
			<th>Item ID</th>
			<th>Item Name</th>
			<th>Quantity Available</th>
			<th>Unit Price</th>
			<th>Item Type</th>
		</tr>
		<c:forEach items="${items}" var="item">
			<tr>
				<td>${item.itemId }</td>
				<td>${item.itemName }</td>
				<td>${item.quantity }</td>
				<td>${item.unitPrice }</td>
				<td>${item.itemType }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<h1><a href="./addItemsToCart">Add Items To Your Cart</a></h1><br>
	<h1><a href="./getBill">Get Bill</a></h1><br>
	<a href="./">Go to Main Page</a>
</body>
</html>