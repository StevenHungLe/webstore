<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<title>Log in</title>
</head>
<body>
	<div class="container">
		<div class="col-md-4 col-md-offset-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Please sign in</h3>
				</div>
				<div class="panel-body">
					<c:if test="${not empty error}">
						<div class="alert alert-danger">
						Wrong username or password<br>
						</div>
					</c:if>
					
					<form action="<c:url value="/j_spring_security_check"></c:url>" method="post">
						<fieldset>
							<div class="form-group">
								<input type="text" class="form-control" name='j_username' placeholder="User Name" />
							</div>
							<div class="form-group">
								<input type="password" class="form-control" name='j_password' placeholder="Password" />
							</div>
							<input class="btn btn-lg btn-success btn-block" type="submit" value="Login"/>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>