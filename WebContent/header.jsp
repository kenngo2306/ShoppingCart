	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand">Shopping Cart!</a>
	    </div>
	    <div>
	      <ul class="nav navbar-nav">
	      	<li><a href="AllProduct">Product List</a></li>

      		

			
			<c:if test="${empty user}">
  					<li><a href="./LoginForm.jsp">Login</a></li>
			</c:if>
			
			<c:if test="${not empty user}">
  					
				<c:choose>
				   <c:when test="${user.userRole eq 0}">
				      <li><a href="ViewOrders">View Orders</a></li>
				      <li><a href="StoreCredit">Manage Credit</a></li>
				      <li><a href="Logout">Log out</a>
				   </c:when>
						
				   <c:otherwise>
          				<li class="dropdown">
					          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${user.userName}
					          									<span class="glyphicon glyphicon-shopping-cart"></span>	 
				          										<span class="badge">
											      						${user.getNumItems()}
				      											</span> 
					          									<span class="caret"></span></a>
					          <ul class="dropdown-menu">
					            <li><a href="Profile">Profile</a></li>
					            <li role="separator" class="divider"></li>
			       				
			       				
						      	<li>
				      					<a href="ShoppingCart"><span class="glyphicon glyphicon-shopping-cart"></span> <span class="badge">
				      						${user.getNumItems()}
				      					</span></a>
		      					</li>
		      					<li role="separator" class="divider"></li>
		      					<li><a href="SellingProducts">Selling Products</a></li>
		      					<li role="separator" class="divider"></li>
		      					<li><a href="ViewOrders">View Orders</a></li>
		      					<li role="separator" class="divider"></li>
		      					<li><a href="Logout">Log out</a>
					          </ul>
	        			</li>
				   </c:otherwise>
				</c:choose>
			</c:if>
      		
	      </ul>
	    </div>
	  </div>
	</nav>