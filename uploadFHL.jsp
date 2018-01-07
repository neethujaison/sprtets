<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="resources/js/ajaxfileupload.js"></script>

<script type="text/javascript">
	function strip(html) {
		var tmp = document.createElement("DIV");
		tmp.innerHTML = html;
		return tmp.textContent || tmp.innerText;
	}
	$(function() {
		$(":button").click(function() {
			ajaxFileUpload();
		})
	})
	function ajaxFileUpload() {
				$.ajaxFileUpload({
					url : 'uploadAttachment.json', // Server request address for file upload
					type : 'post',
					secureuri : false, // Do you need a security protocol ， Generally set to false
					fileElementId : 'multipartfile', // File upload domain ID
					dataType : 'JSON', // return type   Generally set to json
					success : function(data, status) // Server successfully responds to processing function 
					{
						//alert(data);
						newdata = strip(data);
						console.log(data);
						//alert(newdata);
						var json = JSON.parse(newdata);
						if(String(json[0]) == "FileError"){
							alert(11);
							var trs = "<table id='#errorTbl'><thead><tr><td>FileName</td><td>Errors</td></tr></thead><tbody>";
							for (var i = 3; i < json.length; i++) {
								var tmp = json[i].split(":");
								trs += "<tr>";
								trs += "<td>" + tmp[0] + "</td>";
								trs += "<td>" + tmp[1] + "</td>";
							}
							trs += "</tbody></table>";
							$('#tableInfo').parent().html(trs);
							
						}else if(String(json[0]) == "SystemError"){
							alert(22);
							var trs = "<table id='#errorTbl'><thead><tr><td>System Errors</td></tr></thead><tbody>";
							for (var i = 1; i < json.length; i++) {
								trs += "<tr>";
								trs += "<td>" + json[i] + "</td>";
							}
							trs += "</tbody></table>";
							$('#tableInfo').parent().html(trs);
							
						}
						
						if (typeof (data.error) != 'undefined') {
							if (data.error != '') {
								alert(data.error);
							} else {
								alert(data.msg);
							}
						}
					},
					error : function(data, status, e)// Server response failed handler 
					{
						alert(e);
					}
				})
		return false;
	}
</script>


<title>fhl upload</title>
</head>
<body>
	<h2>fhl Upload</h2>
	<form id="fileupload" method="post" enctype="multipart/form-data"
		action="uploaddtl">
		<!-- File input -->
		<input id="multipartfile" name="multipartFile" type="file"
			multiple="multiple" /> <input type="button" value="Upload">
	</form>



	<div id="result">
		<div id="tableInfo"></div>

	</div>

	<div id="controlButtons">
		<button onclick="addRow();">Add row</button>
	</div>
	<table id="myTable">
		<thead>
			<tr>
				<th>First name</th>
				<th>Last name</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</body>
</html>