<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>New/Edit Employee</title>
		<style>
			.error {
				color: #ff0000;
			}
		</style>
	</head>
	<body>
		<div align="center">
			<h1>New/Edit Employee</h1>
			<form:form action="saveEmployee" method="post" modelAttribute="employee">
				<table>
					<form:hidden path="id"/>
					<tr>
						<td>Name:</td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td>Surname:</td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td>Gender:</td>
						<td><form:input path="gender" /></td>
					</tr>
					<tr>
						<td>Date of birth:</td>
						<td><form:input path="birthDate" type="date"/></td>
					</tr>
					<tr>
						<td>Date of hire:</td>
						<td><form:input path="hireDate" type="date"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" value="Save"></td>
					</tr>
				</table>

                <c:if test="${employee.salaries.size() > 0}">
                    <div align="center">
                        <h1>Employee salaries List</h1>
                        <table border="1">
                            <th>Salary</th>
                            <th>From date</th>
                            <th>To date</th>
                            <c:forEach var="salary" items="${employee.salaries}">
                                <tr>
                                    <td><c:out value="${salary.salary}" /></td>
                                    <td><fmt:formatDate value="${salary.dateFrom}" /></td>
                                    <td><fmt:formatDate value="${salary.dateTo}" /></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </c:if>
			</form:form>
		</div>
	</body>
</html>