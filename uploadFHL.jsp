<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>

<script type="text/javascript">
	function uploadFormData() {
		//$('#result').html('');
		var data = new FormData();

		jQuery.each(jQuery('#file')[0].files, function(i, file) {
			data.append('file-' + i, file);
		});
		$.ajax({
			url : 'uploadAttachment.htm',
			data : data,
			processData : false,
			contentType : false,
			type : 'POST',
			success : function(data) {
				json = JSON.parse(data);
				var trs="<table id='#errorTbl'><thead><tr><td>FileName</td><td>Errors</td></tr></thead><tbody>";
				for (var i = 0; i < json.length; i++) {
		            trs+="<tr>";
		            trs+="<td>" + json[i].fileName + "</td>";
		            trs+="<td>" + json[i].fileFormat + "</td>";
		        } 
				trs+="</tbody></table>";
				$('#tableInfo').parent().html(trs);
				alert('success');

			},
			error : function(request, status, error) {
				alert(request.responseText);
			}
		});
	}
</script>
<title>fhl upload</title>
</head>
<body>
	<h2>fhl Upload</h2>
	<form id="form2" method="post" enctype="multipart/form-data">
		<!-- File input -->
		<input id="file" name="file" type="file" />
	</form>

	<button value="Submit" onclick="uploadFormData()">Upload</button>

	<div id="result">
	<div id="tableInfo">
		
	</div>

	</div>
</body>
</html>