<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Employee Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>List of employees</h1>
		
		<table border="1">
            <th>ID</th>
			<th>Name</th>
			<th>Surname</th>
			<th>Gender</th>
			<th>Date of birth</th>
			<th>Date of hire</th>
			<th>Action</th>

			<c:forEach var="employee" items="${listEmployee}">
				<tr>
                    <td><c:out value="${employee.id}" /></td>
					<td><c:out value="${employee.firstName}" /></td>
					<td><c:out value="${employee.lastName}" /></td>
					<td><c:out value="${employee.gender}" /></td>
					<td><fmt:formatDate value="${employee.birthDate}" /></td>
					<td><fmt:formatDate value="${employee.hireDate}" /></td>
					<td><a href="editEmployee?id=${employee.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteEmployee?id=${employee.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<h4>
			Register new employee <a href="newEmployee">here</a>
		</h4>
	</div>
</body>
</html>