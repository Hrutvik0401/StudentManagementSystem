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
	<h1>Student Details</h1>
	<table border="5">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>Actions</th>
	</tr>
	<tbody>
	<c:forEach items="${studlist}" var="s" varStatus="varStatus">
		<tr>
			<td>${s.sid}</td>
			<td>${s.sname}</td>
			<td>${s.email}</td>
			<td>${s.mobile}</td>
			<td>
				<a href="updateform?SId=${s.sid}">Edit</a>
				<a href="deleteStudent?SId=${s.sid}">Delete</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</body>
</html>