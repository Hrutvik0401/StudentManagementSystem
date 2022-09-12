<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registration Form</h1>
<form action="register">
<label><b>Full Name:</b></label>
	<input type="text" name="sname" placeholder="Enter full name" required="required">
<label><b>Email:</b></label>
	<input type="text" name="email" placeholder="Enter EmailId" required="required">
<label><b>Mobile:</b></label>
	<input type="text" name="mobile" placeholder="Enter mobile" required="required">
<label><b>Username:</b></label>
	<input type="text" name="username" placeholder="Enter Username" required="required">
<label><b>Password:</b></label>
	<input type="text" name="password" placeholder="Enter Password" required="required">	
<input type="submit" value="Register">
</form>
</body>
</html>