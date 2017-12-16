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
	<h2>Hawb List goes here</h2><br/>
	
	
	<br/>
	<table border="1">
		<tr>
			<th>AHM Id</th>
			<th>FHL Id</th>
			<th>Hawb Id</th>
			<th>Hawb No</th>
			<th>Mawb No</th>
			<th>NoOfPieces</th>
			<th>Weight</th>
			<th>Goods Description</th>
			<th>Upload Validation</th>
			<th>IsFile</th>
			<th><a href="deleteAllHawb">Delete All</a></th>
		</tr>
		<c:forEach var="hawb" items="${hawbList }">
			<tr>
				<td>${hawb.cra_ahm_detail_stg_id}</td>
				<td>${hawb.cra_fhl_upload_detail_id}</td>
				<td>${hawb.cra_hawb_detail_stg_id}</td>
				<td>${hawb.hawb_number}</td>
				<td>${hawb.mawb_number}</td>
				<td>${hawb.hawb_noofpieces}</td>
				<td>${hawb.hawb_weight}</td>
				<td>${hawb.goods_description }</td>
				<td>${hawb.docStatus}</td>
				<td>${hawb.isFile }</td>
				<c:choose>
					<c:when test="${hawb.isFile }">
						<c:if test="${hawb.docStatus ne 'Uploaded'}">
							<td><a href="deleteHawb/${hawb.cra_hawb_detail_stg_id}">Delete</a></td>
						</c:if>
					</c:when>
					<c:otherwise>
						<td><a href="deleteHawb/${hawb.cra_hawb_detail_stg_id}">Delete</a></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
		</table>
		
</body>
</html>