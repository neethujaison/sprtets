<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View List</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>

<script type="text/javascript">
function deleteFn(row,dataKey){
	//var btn=document.getElementById("2");
	var btn = $('#'+dataKey)[0];
	alert(btn);
	var r=btn.closest('tr');
	var nRow = r;
	alert(nRow);
	 r.remove();
	
}
</script>
</head>
<body>
	<h2>List goes here</h2><br/>
	<form name="serachForm" method="post" action="search">
	<div class="row">
	     <div class="small-3 columns">
	        <input type="text" id="txt" name="searchString">
	      </div>
	<br/>
	       <div class="small-5 columns end">
	         <button id="button-id" type="submit">Search List</button>
	       </div>
	
	   </div>
	</form>
	 <div class="row">
	      <div>
	         ${searchTerm}
	     </div>
	</div>
	
	<br/>
	<table border="1">
		<tr>
			<th>User Id</th>
			<th>Name</th>
			<th>ContactNo</th>
			<th>Username</th>
			<th>Password</th>
			<th><input type="button" value="DeletALL" onclick="javascript:deleteFn(this,2)"/></th>
		</tr>
		<c:forEach var="user" items="${list }">
			<tr>
				<td>${user.user_id}</td>
				<td>${user.user_name}</td>
				<td>${user.user_contactno}</td>
				<td>${user.user_username}</td>
				<td>${user.user_password}</td>
				<td><input type="button" value="Delete" id="${user.user_id}"/><a href="editUser/${user.user_id}">Edit</a><br/><a href="deleteUser/${user.user_id}">Delete</a></td>
			</tr>
		</c:forEach>
		</table>
		 <br/>  
   <a href="showList/1">1</a>   
   <a href="showList/2">2</a>   
   <a href="showList/3">3</a>  
		
</body>
</html>