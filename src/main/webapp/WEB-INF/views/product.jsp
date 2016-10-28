<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>

<script>
	// display alert box when an order is made
	if ( ${orderMade} == true )
	{
		window.alert("Thank you for placing this order. Your order will be delivered in only one millennium!");
	}
</script>
	
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<title>Product</title>
</head>

<body>
	<section>
		<div class="jumbotron">
			<div class="container text-center">
				<h1>Product Detail</h1>
				<a href="/webstore" class="btn btn-primary btn-lg">Home</a>
			</div>
		</div>
	</section>
	
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
				<strong>Item Code : </strong>
				<span class="label label-warning">${product.productId}</span>
				</p>
				<p>
				<strong>manufacturer</strong> : ${product.manufacturer}
				</p>
				<p>
				<strong>category</strong> : ${product.category}
				</p>
				<p>
				<strong>Availble units in stock </strong> : ${product.unitsInStock}
				</p>
				<h4>${product.unitPrice} USD</h4>
				<p>
				<button class="btn btn-warning btn-large"
				onclick="var orderLink = '/webstore/order/${product.productId}/' + window.prompt('enter quantity to order','1');
				location.href = orderLink">
					<span class="glyphicon-shopping-cart glyphicon"></span> Order Now
				</button>
				</p>
					<a href="<spring:url value="/products"/>" class="btn btn-info">
						<span class="glyphicon glyphicon-hand-left"></span>
						Back
					</a>
				<p>
			</div>
		</div>
	</section>
</body>
</html>