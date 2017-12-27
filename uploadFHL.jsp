<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="<c:url value="/resources/js/ajaxfileupload.js" />"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

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
		$
				.ajaxFileUpload({
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
						json = JSON.parse(newdata);
						alert(json[0]);
						alert(json[1]);
						alert(json[2]);
						alert(json[3]);
						var trs = "<table id='#errorTbl'><thead><tr><td>FileName</td><td>Errors</td></tr></thead><tbody>";
						for (var i = 2; i < json.length; i++) {
							var tmp = json[i].split("-");
							trs += "<tr>";
							trs += "<td>" + tmp[0] + "</td>";
							trs += "<td>" + tmp[1] + "</td>";
						}
						trs += "</tbody></table>";
						$('#tableInfo').parent().html(trs);
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
<script type="text/javascript">
	var count = 0;

	$(document).ready(function() {
		$('table#myTable').dataTable({
			'bFilter' : false,
			'bInfo' : false,
			'bPaginate' : false,
		});

		// Add initial row
		addRow("neethu", "jaison");
	});

	function addRow(first, second) {
		$('table#myTable').dataTable().fnAddData(
				[ '<input type="text" name="' + first + '">',
				  '<input type="text" name="' + second + '">' ]);

		count++;
	}
</script>
<script type="text/javascript">
	/*function uploadAttachmentUsingAjax() {

		$.AjaxFileUpload({
			url : 'uploadAttachment.htm',
			secureuri : false,
			fileElementId : multipartfile,
			async : false,
			success : function(data) {

				alert('uploaded');
				alert(data);

			},
			error : function(request, status, error) {
				alert(request.responseText);
			}
		});
	}

	function uploadFormData() {
		//$('#result').html('');
		var data = new FormData();

		jQuery.each(jQuery('#file')[0].files, function(i, file) {
			data.append('file-' + i, file);
		});
		$
				.ajax({
					url : 'uploadAttachment.htm',
					data : data,
					processData : false,
					contentType : false,
					type : 'POST',
					success : function(data) {
						json = JSON.parse(data);
						var trs = "<table id='#errorTbl'><thead><tr><td>FileName</td><td>Errors</td></tr></thead><tbody>";
						for (var i = 0; i < json.length; i++) {
							trs += "<tr>";
							trs += "<td>" + json[i].fileName + "</td>";
							trs += "<td>" + json[i].fileFormat + "</td>";
						}
						trs += "</tbody></table>";
						$('#tableInfo').parent().html(trs);
						alert('success');

					},
					error : function(request, status, error) {
						alert(request.responseText);
					}
				//});
	}*/
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