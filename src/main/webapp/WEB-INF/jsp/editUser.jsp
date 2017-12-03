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
	<h2>Edit User Page</h2>
	<form:form id="editUserForm" action="/SpringUserHibernate/editUserProcess"  commandName="userForm" method="post">
		<table>
			<tr>
				<td>User Id</td>
				<td><form:input path="userid" readonly="true" value="${userForm.userid}"></form:input></td>
				
			</tr>
			<tr>
				<td>Enter Name</td>
				<td><form:input path="name" value="${userForm.name}"></form:input></td>
				<td><form:errors path="name" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="username" >Username</form:label></td>
				<td><form:input path="username" value="${userForm.username}" /></td>
				<td><form:errors path="username" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><form:input path="password" value="${userForm.password}"></form:input></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter Contact No</td>
				<td><form:input path="contactno" value="${userForm.contactno}"></form:input></td>
			</tr>
			<tr>

				<td><input type="submit" value="Save User" name="submitbtn" /></td>
			</tr>
		</table>
	</form:form>

</body>