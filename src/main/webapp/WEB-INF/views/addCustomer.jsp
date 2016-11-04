<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<title>Add New Customer</title>
</head>
<body>
	<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">Logout</a>
	<section class = "container">
		<form:form modelAttribute="newCustomer" class = "form-horizontal" method="post">		
			<fieldset>
				<legend><strong>Add new customer</strong></legend>
				<div class="form-group">
					<label class="control-label col-lg-2" for="email">Email/Username</label>
					<div class="col-lg-10">
						<form:input path="customerEmail" id="email" type="text" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="password">Password</label>
					<div class="col-lg-10">
						<form:password path="customerPassword" id="password" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="fullname">Full Name</label>
					<div class="col-lg-10">
						<form:input path="customerName" id="fullname" type="text" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="address">Address</label>
					<div class="col-lg-10">
						<form:input path="customerAddress" id="address" type="text" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" value="submit" class="btn btn-primary" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>