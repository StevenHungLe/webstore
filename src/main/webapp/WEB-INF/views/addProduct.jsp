<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<title>Add product</title>
</head>
<body>
	<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">Logout</a>
	<section class = "container">
		<form:form modelAttribute="newProduct" class="form-horizontal">
			<fieldset>
				<legend><strong>Add a new product</strong></legend>
				<div class="form-group">
					<label class="control-label col-lg-2" for="name">Name</label>
					<div class="col-lg-10">
						<form:input path="name" id="name" type="text" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="unitPrice">Unit Price</label>
					<div class="col-lg-10">
						<form:input path="unitPrice" id="unitPrice" type="number" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="manufacturer">Manufacturer</label>
					<div class="col-lg-10">
						<form:input path="manufacturer" id="manufacturer" type="text" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="category">Category</label>
					<div class="col-lg-10">
						<form:input path="category" id="category" type="text" class="form:input-large" />
					</div>
				</div>
				<div class="form-group" >
					<label class="control-label col-lg-2" for="unitsInStock">Units In Stock</label>
					<div class="col-lg-10">
						<form:input path="unitsInStock" id="unitsInStock" type="number" class="form:input-large" />
					</div>
				</div>
				<div class="form-group" style="display:none">
					<label class="control-label col-lg-2" for="unitsInOrder">Units In Order</label>
					<div class="col-lg-10">
						<form:input path="unitsInOrder" id="unitsInOrder" type="number" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="description">Description</label>
					<div class="col-lg-10">
						<form:textarea path="description" id="description" row="2" class="form:input-large" />
					</div>
				</div>
				<div class="form-group" style="display:none">
					<label class="control-label col-lg-2" for="discontinued">Discontinued</label>
					<div class="col-lg-10">
						<form:checkbox path="discontinued" id="discontinued" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="condition">Condition</label>
					<div class="col-lg-10" id="condition">
						<form:radiobutton path="condition" value="New" />New
						<form:radiobutton path="condition" value="Used" />Old
						<form:radiobutton path="condition" value="Refurbished" />Refurbished
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" value="Submit" class=" btn btn-primary" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>