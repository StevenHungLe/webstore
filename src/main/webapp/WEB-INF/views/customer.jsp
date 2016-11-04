<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<title>Customer Detail View</title>
</head>
<body>
	<section class="jumbotron">
		<div class="container">
			<h1>Customer Detailed View</h1>
		</div>
	</section>
	
	<section class="container">
		<h2>${customer.customerName}</h2><br>
		<p>Customer Id: ${customer.customerId}</p>
		<p>${customer.customerAddress}</p>
		<p>${customer.customerEmail}</p>
		<p>Number or orders made: ${customer.numberOfOrdersMade}</p>
	</section>

</body>
</html>