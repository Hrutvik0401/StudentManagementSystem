<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${msg}
<h1>Student Management System!!!</h1>
<form action="login">
<label><b>User Name :: </b></label>
<input type="text" name="u" placeholder="Enter Username">
<label><b>Password :: </b></label>
<input type="text" name="p" placeholder="Enter Password">
<input type="submit" value="Login"><br><br>
<input type="button" onclick="location.href='Registration.jsp'" value="Sign In">
<!-- <a type="button" href="Registration.jsp">Sign IN</a> -->
</form>
</body>
</html>