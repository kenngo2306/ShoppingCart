<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Add to Cart</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand">Shopping Cart!</a>
	    </div>
	    <div>
	      <ul class="nav navbar-nav">
	      	<li><a href="AllProduct">Product List</a></li>
	      	<li>
	      		<a href="ShoppingCart"><span class="glyphicon glyphicon-shopping-cart"></span> <span class="badge">${numItems}</span></a></li>
	      </ul>
	    </div>
	  </div>
	</nav>
	<div class="row">
  <div class="row col-sm-6 col-sm-offset-3">
    <div class="thumbnail">
      <img src="${product.imageLink}" alt="thumb">
      <div class="caption">
        <h3>${product.productName}</h3>
        <p>${product.productDescription}</p>
        <p>$ ${product.price} </p>
        <form action = 'AddToCart' method = 'POST'>
        	<input type='hidden' name ='productId' value = '${product.productId}'/>
        	<input type='number' name='quantity'/>
        	<input type = 'submit' class='btn btn-primary'/>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>