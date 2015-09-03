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

<title>Store Credit</title>
</head>
<body>
	<jsp:include page="./header.jsp"/>
	<form role = "form" action="StoreCredit" method="POST">
	
		<table class="table">
			<thead>
				<tr>
					<td> </td>
					<td>Username</td>
					<td>Credit</td>
				</tr>
			</thead>
			<c:forEach var="tempUser" items="${users}">
				<tr>
					<td><input type="radio" name="userId" value="${tempUser.userId}"/></td>
					<td>${tempUser.userName}</td>
					<td><input type="number" name="storeCredit${tempUser.userId}" value="${tempUser.storeCredit}" /></td>
				</tr>

			</c:forEach>
		</table>
		<input type="submit" class="btn btn-success" value="Add Credit"/> 
	</form>
</body>
</html>