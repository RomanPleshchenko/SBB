<%--
  Created by IntelliJ IDEA.
  User: ?????
  Date: 05.04.2017
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<jsp:include page="header.jsp" flush="true" >
		<jsp:param name="title" value="Users"/>
	</jsp:include>
</head>

<body>

<jsp:include page="navigation.jsp"></jsp:include>

<div class="container">
	<h2>List of users</h2>
	<table class="table table-hover">
		<thead>
		<tr>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Email</th>
			<th>SSO ID</th>
			<sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')">
				<th width="100"></th>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<th width="100"></th>
			</sec:authorize>

		</tr>
		</thead>
		<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td>${user.ssoId}</td>
				<sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('DBA')">
					<td><a href="<c:url value='/edit-user-${user.ssoId}' />" class="btn btn-success custom-width">edit</a></td>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<td><a href="<c:url value='/delete-user-${user.ssoId}' />" class="btn btn-danger custom-width">delete</a></td>
				</sec:authorize>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<div class="well">
			<a href="<c:url value='/newuser' />">Add New User</a>
		</div>
	</sec:authorize>
</div>

<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>
