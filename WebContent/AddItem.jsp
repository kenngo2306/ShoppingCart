<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.min.js"></script>
<link rel="stylesheet" type="text/css" href="style.css">
<title>Add Item</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="panle panel-primary col-sm-6 col-sm-offset-3">
		<div class="panel-heading">Add Item</div>

		<div class="panel-body">
			<c:if test="${not empty errorMessage}">
				<div class="alert alert-danger">
					<c:out value="${errorMessage}" />
				</div>
			</c:if>
			<form role="form" action="AddProduct" method="POST">
				<div class="form-group">
					<label for="productName">Product Name:</label> <input type="text"
						class="form-control" name="productName"  required />
				</div>

				<div class="form-group">
					<label for="imageLink">Image Link:</label> <input type="text"
						class="form-control" name="imageLink"  required />
				</div>

				<div class="form-group">
					<label for="productDescription">Description:</label> <input
						type="text" class="form-control" name="productDescription" 
						required />
				</div>

				<div class="form-group">
					<label for="productType">Product Type:</label> <input
						type="text" class="form-control" name="productType" 
						required />
				</div>
				
				<div class="form-group">
					<label for="price">Price:</label> <input type="text"
						class="form-control" name="price" required />
				</div>

				<div class="form-group">
					<label for="shippingcost">Shipping Cost:</label> <input type="text"
						class="form-control" name="shippingcost" required />
				</div>


				<div class="form-group">
					<label for="available">Available:</label> <select
						class="form-control" id="available" name="available">
						<option>Yes</option>
						<option>No</option>
					</select>
				</div>

				<div class="form-group">
					<button type="submit" value="submit" class="btn btn-default">Add
						Item</button>


				</div>

			</form>

		</div>
	</div>
</body>
</html>