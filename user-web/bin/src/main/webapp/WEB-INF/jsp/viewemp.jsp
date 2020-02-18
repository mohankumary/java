
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<body>
	<h1>Employees List</h1>
	<table border="2" width="70%" cellpadding="2">
		<form modelAttribute="request" name="request">
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Salary</th>
				<th>Designation</th>
				<th>Experience</th>
				<th>Joining Date</th>
				<th>Manager</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${reqList}" var="reqList">
				<tr>
					<td>${reqList.id}</td>
					<td>${reqList.first_name}</td>
					<td>${reqList.last_name}</td>
					<td>${reqList.salary}</td>
					<td>${reqList.designation}</td>
					<td>${reqList.experience}</td>
					<td>${reqList.joining_date}</td>
					<td>${reqList.manager}</td>
					<td><a href="editemp/${reqList.id}">Edit</a></td>
					<td><a href="deleteemp/${reqList.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</form>
	</table>
	<br />
	<a href="/empform">Add New Employee</a>
</body>
</html>