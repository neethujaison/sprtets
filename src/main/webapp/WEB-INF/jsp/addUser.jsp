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
	<h2>Add User Page</h2>
	<form:form id="addUserForm" action="addUserProcess"  commandName="userForm" method="post">
		<table>
			<tr>
				<td>Enter Name</td>
				<td><form:input path="name"></form:input></td>
				<td><form:errors path="name" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><form:input path="password"></form:input></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter Contact No</td>
				<td><form:input path="contactno"></form:input></td>
			</tr>
			<tr>

				<td><input type="submit" value="Add User" name="submitbtn" /></td>
			</tr>
		</table>
	</form:form>

</body>