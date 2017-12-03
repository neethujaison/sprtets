<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User Page</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	function doAjaxPost() {
	$.ajax({
	    type: "POST",
	    url: 'saveUser',
	    data: $('form[name=addUserForm]').serialize(),
	    success: function(response){
            if(response.validated){
               //Set response
               $('#resultContainer pre code').text(JSON.stringify(response.userForm));
               $('#resultContainer').show();
            
            }else{
              //Set error messages
              $.each(response.errorMessages,function(key,value){
  	            $('input[name='+key+']').after('<span cssClass="error">'+value+'</span>');
              });
            }
	    },
	    error: function(e){
	        alert('Error: ' + JSON.stringify(e));
	    }
	});
	}

	</script>
</head>
<body>
	<h2>Insert User using AJax Form SubmissionPage</h2>
	<form:form name="addUserForm" action="addUserProcess"
		modelAttribute="userForm" method="post">
		<table>
			<tr>
				<td>Enter Name</td>
				<td><form:input path="name"></form:input></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><form:input path="password"></form:input></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Enter Contact No</td>
				<td><form:input path="contactno"></form:input></td>
			</tr>
			<tr>
				<td><input type="button" value="Add User"
					onclick="doAjaxPost()" /></td>
			</tr>
		</table>
	</form:form>
	<!-- Result Container  -->
	<div id="resultContainer" style="display: none;">
		<hr />
		<h4 style="color: green;">JSON Response From Server</h4>
		<pre style="color: green;">
    <code></code>
   </pre>
	</div>
</body>