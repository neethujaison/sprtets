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
	<h2>Submit Ahm Page</h2>
	<form:form id="submitAhmForm" action="submitAhmProcess"  commandName="ahmForm" method="post">
		<table>
			<tr>
				<td>Master AWB No</td>
				<td><form:input path="mawbno"></form:input></td>
				<td><form:errors path="mawbno" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="noofpieces">No Of Pieces</form:label></td>
				<td><form:input path="noofpieces" /></td>
				<td><form:errors path="noofpieces" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Weight</td>
				<td><form:input path="weight"></form:input></td>
				<td><form:errors path="weight" cssClass="error"/></td>
			</tr>			
			<br/>
			<a href="uploadHawb">Upload HAWB</a><br/>
			<a href="addHawb">Add HAWB</a><br/>
			
			<tr>

				<td><input type="submit" value="Save As Draft" name="submitbtn" /></td>
			</tr>
		</table>
		
		
		<br/>
		<a href="showHawbList">Show HAWB List</a><br/>
	</form:form>

</body>