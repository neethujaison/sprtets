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
	<h2>Add HAWB Page</h2>
	<form:form id="submitHawbForm" action="submitHawbProcess"  commandName="hawbForm" method="post">
		<table>
			<tr>
				<td>HAWB No</td>
				<td><form:input path="hawbno"></form:input></td>
				<td><form:errors path="hawbno" cssClass="error"/></td>
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
			<tr>
				<td>Goods description</td>
				<td><form:input path="goods_description"></form:input></td>
				<td><form:errors path="goods_description" cssClass="error"/></td>
			</tr>	
			<tr>

				<td><input type="submit" value="Save" name="submitbtn" /></td>
			</tr>
		</table>
	</form:form>

</body>