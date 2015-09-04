<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="jquery.rating.css">
<script src="jquery.rating.js"></script>
<title>Welcome to Tian Mao!</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<table class="table table-striped">
	<thead><tr><th>Product Name</th><th>Quantity</th><th>Price</th><th>Return</th></tr></thead>
 	<c:forEach var="line" items="${lineItems}">
		<tr>
			<td>${line.shopproduct.productName}</td>
			<td>${line.quantity}</td>
			<td>${line.shopproduct.price}</td>
			<td><a href = "ConfirmReturnServlet?lineid=${line.lineItemId}"><button type="button" class="btn pull-left btn-info btn-lg">Return</button></a></td>
		</tr>
	</c:forEach> 
	</table>
<br>
<a href = "ProductServlet"><button type="button" class="btn btn-info btn-lg">Back>>></button></a>
<a href = "AddCartServlet?pid=<%= request.getParameter("pid") %>"><button type="button" class="btn pull-left btn-info btn-lg">Add to Shopping Cart</button></a>
<br>
</body>
</html>