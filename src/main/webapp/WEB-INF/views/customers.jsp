<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
		<title>Products</title>
	</head>
	
	<body>
		<section>
			<div class="jumbotron">
				<div class="container text-center">
					<h1>Customers</h1>
					<h2>List of all of our customers</h2>
					<a href="/webstore" class="btn btn-primary btn-lg">Home</a>
				</div>
			</div>
		</section>
	
		<section class="container">
			<div class="row">
				<c:forEach var="customer" items="${customers}">
					<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
						<div class="thumbnail">
							<div class="caption">
								<h3>${customer.customerName}</h3>
								<p>${customer.customerAddress}</p>
								<p>${customer.customerEmail}</p>
								<p>Number of orders made: ${customer.numberOfOrdersMade} </p>
								<a href="<c:url value="customers/customer"> 
									<c:param name="customerId" value="${customer.customerId}" />
									</c:url>" class="btn btn-info">
									<span class="glyphicon glyphicon-info-sign"></span> Details
									</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>
	
	</body>
</html>