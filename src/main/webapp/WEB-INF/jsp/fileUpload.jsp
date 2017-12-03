<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File upload</title>
</head>
<body>
<h2>File Upload</h2>
<form name="uploadForm" action="uploadFileProcess" method="post" enctype="multipart/form-data">
	
	Description:<input type="text" name="description"/><br/>
	Upload File 1:<input type="file" name="uploadFile"/><br/>
	Upload File 2: <input type="file" name="uploadFile"/>
	<br/>
	<input type="submit" value="Upload"/>

</form>

</body>
</html>