<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fill Form</title>
</head>
<body>
		<!-- <form action="save" method="post">
			Roll No. : <input type="text" name="rollno">
			Name : <input type="text" name="name">
			City : <input type="text" name="city">
			<input type="submit">
		</form> -->
		<form:form action="/CRUDSpringMVC/saveEdit" method="post">
			<form:input path="rollNumber" readonly="true"/>
			<form:input path="name"/>
			<form:input path="city"/>
			<input type="submit" value="Save">
		</form:form>
</body>
</html>