<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"><title>Add User Page</title>
<style>
.error {
color: red; font-weight: bold; 
}
</style>
</head>
<body>
	
	 <div class="row">
	      <div>
	         ${searchTerm}
	     </div>
</div>
<table border="1">
		<tr>
			<th>User Id</th>
			<th>Name</th>
			<th>ContactNo</th>
			<th>Username</th>
			<th>Password</th>
			<th></th>
		</tr>${list}
		<c:forEach var="user" items="${list}">
			<tr>
				<td>${user.user_id}</td>
				<td>${user.user_name}</td>
				<td>${user.user_contactno}</td>
				<td>${user.user_username}</td>
				<td>${user.user_password}</td>
				<td><a href="editUser/${user.user_id}">Edit</a><br/><a href="deleteUser/${user.user_id}">Delete</a></td>
			</tr>
		</c:forEach>
		</table>
</body>
</html>