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
<title>Shopping Cart</title>
<style>
	.item
	{
		padding:20px;
		margin-top:20px;
		border: 1px solid black;
		height: 250px;
	}
	img
	{
		margin:auto; 
		width:100px;
		height:100px;
		display:block;
		float:left;
	}
</style>

</head>
<body>
	<jsp:include page="./header.jsp"/>
	<div class=" col-sm-6 col-sm-offset-3">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Picture</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>LineTotal</th>
				</tr>
			</thead>
			<c:forEach var="lineItem" items="${order.shoplineitems}">
						<tr>
							<td>${lineItem.shopproduct.productName}</td>
							<td>${lineItem.shopproduct.productDescription}</td>
							<td><img src="${lineItem.shopproduct.imageLink}" alt = "${lineItem.shopproduct.productName}"/></td>
							<td>${lineItem.quantity}</td>
							<td align="right">$ ${lineItem.shopproduct.price}</td>
							<td align="right">$ ${lineItem.getLineTotal()}</td>
						</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="right">Subtotal: </td>
				<td align="right">$ ${order.getFormattedSubtotal()}</td>
			</tr>
			<tr>
				<td colspan="5" align="right">Tax(6%): </td>
				<td align="right">$ ${order.getFormattedTax()}</td>
			</tr>
			<tr>
				<td colspan="5" align="right">Order Total: </td>
				<td align="right">$ ${order.getFormattedTotal()}</td>
			</tr>
		</table>

		
	</div>
	<div class=" col-sm-6 col-sm-offset-3">
			<form role="form" action="PlaceOrder" method="POST">
				<div class="input-group">
					<label for="creditCard">Credit Card Number: </label>
					<input type="number" name="creditCard" class="form-control" required/>
				</div>
				<div class="input-group">
					<label for="billingAddress">Billing Address: </label>
					<input type="text" name="billingAddress" class="form-control" required/>
				</div>
				<div class="input-group">
					<label for="shippingAddress">Shipping Address: </label>
					<input type="text" name="shippingAddress" class="form-control" required/>
				</div>
				<div class="input-group">
					<input type="submit" value="Place Order" class="btn btn-success"/>
				</div>
			</form>
	</div>


</body>
</html>