<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Data</title>
</head>
<body>
	<h1>Show Table</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Roll No.</th>
			<th>City</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${students}" var="std">
			<tr>
				<td>${std.name}</td>
				<td>${std.rollNumber}</td>
				<td>${std.city}</td>
				<%-- <td><a href="edit/${std.rollNumber}">Edit</a></td> OR --%> 
				<td>
					<form action="edit/${std.rollNumber}" method="post">
						<button>Edit</button>
					</form>
				</td>
				<td>
					<form action="delete/${std.rollNumber}" method="post">
						<button>Delete</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>