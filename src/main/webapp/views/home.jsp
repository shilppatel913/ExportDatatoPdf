<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<form action="users/export/pdf" method="post">
		<div>
		<label>Enter Name to filter data and get in pdf form</label>
		<input name="varName" type="text" id="varName" /></div>
		
		<div>
		<label>Enter Time to filter data and get in pdf form</label>
		<input name="timems" type="text" id="timems" />
		</div>
		
		<label>Enter time1 to filter data and get in pdf form</label>
		<input name="time1" type="text" id="timestring1" />
		</div>
		
		<label>Enter time2 to filter data and get in pdf form</label>
		<input name="time2" type="text" id="timestring2" />
		</div>
		
		<button type="submit">Generate Pdf</button>
	</form>
</div>

</body>
</html>