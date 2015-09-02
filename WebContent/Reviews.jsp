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

<title>Product Reviews</title>

</head>
<body>
	<jsp:include page="./header.jsp"/>
	
	<div class="col-sm-8 col-sm-offset-3">
		<div class="row">
			<img src="${product.imageLink}" alt ="product.productName" width="100px" height="100px"/>
		</div>
		
		<div class="row">
			<p>${product.productName}</p>
			<p>${product.productDescription}</p>
		</div>
		
		<div class="row">
			<table class="table">
				<tr>
					<th>User</th>
					<th>Review</th>
					<th>Rating</th>
				</tr>
				<c:forEach var="review" items="${product.shopreviews}">
					<tr>
						<td>${review.shopuser.userName}</td>
						<td>${review.reviewContent}</td>
						<td>${review.stars}</td>
					</tr>
				</c:forEach>
				<c:if test="${not empty user and user.hasNoReview(product.productId)}">
					<form action="Reviews" method="POST">
						<tr>
							<td colspan="2"><label for="content">Reviews:</label><input type="text" name="content" /></td>
							
							<td>
								<select name="stars">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
								<input type="hidden" name="productId" value="${product.productId}"/>
								<input type="submit" value="Submit" class="btn btn-primary"/>
							</td>
						</tr>
					</form>
				</c:if>

			</table>
		</div>
	</div>

</body>
</html>