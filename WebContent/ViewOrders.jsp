<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.min.js"></script>
<title>All Orders</title>
</head>
<body>
	<jsp:include page="./header.jsp"/>
	
	<c:forEach var="order" items="${orders}">
		<div class="panel panel-primary col-sm-6 col-sm-offset-3">
			<div class="panel-heading">
				<h4>Order Number: ${order.orderId}</h4>
				<h4>Order By: ${order.shopuser.userName}</h4>

			</div>
			<div class="panel-body">
				<p>Order Date: ${order.orderDate}</p>
				<p>Order total: ${order.orderTotal}</p>
				<p>Order Status: ${order.orderStatus}</p>

			</div>
			<table class="table">
				<tr>
					<th>Product</th>
					<th>Quantity</th>
					<th>Price</th>
				</tr>
				<c:forEach var="item" items="${order.shoplineitems}">
					<tr>
						<td>${item.shopproduct.productName}</td>
						<td>${item.quantity}</td>
						<td>${item.shopproduct.price}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:forEach>
</body>
</html>