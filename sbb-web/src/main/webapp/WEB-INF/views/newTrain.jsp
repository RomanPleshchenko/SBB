<%--
  Created by IntelliJ IDEA.
  User: РОМАН
  Date: 06.04.2017
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <jsp:include page="header.jsp" flush="true" >
        <jsp:param name="title" value="New train"/>
    </jsp:include>
</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>

<form:form method="POST" commandName="train" action="newTrain" class="box login">
    <fieldset class="boxBody">

        <td>${error} <br></td>

        <form:label path="number">Number:</form:label>
        <form:input path="number" />

        <form:label path="capacity">Capacity:</form:label>
        <form:input path="capacity"/>

    </fieldset>

    <footer>
        <input type="submit" class="btnLogin" value="Save" tabindex="4">
    </footer>

</form:form>

<jsp:include page="footer.jsp"/>
</body>
</html>
