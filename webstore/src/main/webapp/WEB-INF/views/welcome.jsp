<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<title>Welcome</title>
</head>

<body>
	<div class="jumbotron" style="background-color:yellow">
		<div class="container text-center">
			<h1>${greeting}</h1>
			<h2>${tagline}</h2>
		</div>
	</div>
	
	<div class="text-center">
		<a href="./products" class="btn btn-primary btn-lg" style="margin-bottom: 20px">
			Our Products
		</a>
	</div>
	
	<div class="text-center">
		<a href="./customers" class="btn btn-primary btn-lg">
			Our Customers
		</a>
	</div>
</body>

</html>