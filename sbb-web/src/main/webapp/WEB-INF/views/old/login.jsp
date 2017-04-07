<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="<c:url value="/static/css/home.css"/>" rel="stylesheet"><%--not workong?????--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authorization</title>

</head>

<body>

<form:form method="POST" commandName="findTrainByParameter" action="findTrainByParameter" class="box login">
	<fieldset class="boxBody">

		<form:label path="name">Name:</form:label>
		<form:input path="name" />

		<form:label path="password">Password:</form:label>
		<form:password path="password"/>

	</fieldset>

	<footer>
		<input type="submit" class="btn btn-success" value="to find" tabindex="4">
	</footer>

</form:form>

</body>
</html>