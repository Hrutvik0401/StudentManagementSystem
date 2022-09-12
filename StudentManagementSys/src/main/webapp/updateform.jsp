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
	<h1>Update Form</h1>
<form action="updateStudent" method="post">
	<lable>Student Id :</lable>
	<input type="hidden" name="sid" value="${student.sid}">
	<lable>Full Name :</lable>
	<input type="text" name="sname" value="${student.sname}">
	<lable>Email Id :</lable>
	<input type="text" name="email" value="${student.email}">
	<lable>UserName :</lable>
	<input type="text" name="username" value="${student.username}">
	<lable>Password :</lable>
	<input type="text" name="password" value="${student.password}">
	<lable>Mobile :</lable>
	<input type="text" name="mobile" value="${student.mobile}">	
	<button type="submit">update</button>
</form>
</body>
</html>