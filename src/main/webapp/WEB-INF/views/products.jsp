<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

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
					<h1>Products</h1>
					<h2>${tagline}</h2>
					<a href="/webstore" class="btn btn-primary btn-lg" style="margin-right:20px">
					Home
					</a>
					<a href=#filter-form class="btn btn-primary btn-lg">Filter</a>
				</div>
			</div>
		</section>
	
		<section class="container">
			<div class="row">
				<c:forEach var="product" items="${products}">
					<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
						<div class="thumbnail">
							<div class="caption">
								<h3>${product.name}</h3>
								<p>${product.description}</p>
								<p>${product.unitPrice} USD</p>
								<p>Units in stock: ${product.unitsInStock} </p>
								<p>
									<a href="products/product?id=${product.productId}" class="btn btn-info">
										<span class="glyphicon glyphicon-info-sign"></span>
										Details
									</a>								
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>
		
		<section class="container"  id="filter-form">
			<form method="post">
				<fieldset>
					<legend>filters</legend>
					
					<div class="form-group">
						<label for="brand" class="control-label col-sm-2">Brand</label>
						<div class="col-sm-4" id="brand">
							<input type="radio" name="brand" value="Apple">Apple  
							<input type="radio" name="brand" value="Dell">Dell  
							<input type="radio" name="brand" value="Google">Google
						</div>  
					</div>
					<br>
					
					<div class="form-group">
						<label for="category" class="control-label col-sm-2">Category</label>
						<div class="col-sm-4"  id="category">
							<input type="radio" name="category" value="Smart Phone">Smart Phone  
							<input type="radio" name="category" value="Laptop">Laptop  
							<input type="radio" name="category" value="Tablet">Tablet
						</div>  
					</div>
					<br>
					
					<div class="form-group">
						<label for="priceFrom" class="control-label col-sm-2">Price ranges from</label>  
						<input type="number" class="col-sm-1" name="priceFrom" id="priceForm" value="0"> 

						<label for="priceTo" class="control-label  col-xs-1">   to </label>  
						<input type="number" class="col-sm-1" name="priceTo" id="priceTo" value="0">
					</div>
					<br>
					
					<input type="submit" value="Submit">
				</fieldset>
			</form>
		</section>
	
	</body>
</html>