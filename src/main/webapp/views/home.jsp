<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello click on the below link to get data in the pdf form</h1>
<div class="container">
	<form action="users/export/pdf" method="post">
		<label>Enter Name to filter data and get in pdf form</label>
		<input name="pName" type="text" id="pName" />
		<button>Generate Pdf</button>
	</form>
</div>
</body>
</html>