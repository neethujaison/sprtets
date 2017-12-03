<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View List</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

</head>
<body>
	list goes here
	<table border="1">
		<tr>
			<th>User Id</th>
			<th>Name</th>
			<th>ContactNo</th>
			<th>Username</th>
			<th>Password</th>
			<th></th>
		</tr>
		<c:forEach var="user" items="${list }">
			<tr>
				<td>${user.user_id}</td>
				<td>${user.user_name}</td>
				<td>${user.user_contactno}</td>
				<td>${user.user_username}</td>
				<td>${user.user_password}</td>
				<td><a href="editUser/${user.user_id}">Edit</a><br/><a href="deleteUser/${user.user_id}">Delete</a></td>
			</tr>
		</c:forEach>
</body>
</html>