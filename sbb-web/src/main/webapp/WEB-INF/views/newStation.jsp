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

<html>
<head>
    <jsp:include page="header.jsp" flush="true" >
        <jsp:param name="title" value="New station"/>
    </jsp:include>
</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>

<form:form method="POST" commandName="station" action="newStation" class="box login">
    <fieldset class="boxBody">

        <td>${error} <br></td>

        <form:label path="name">Name:</form:label>
        <form:input path="name" />

    </fieldset>

    <footer>
        <input type="submit" class="btnLogin" value="Save" tabindex="4">
    </footer>

</form:form>

<jsp:include page="footer.jsp"/>
</body>
</html>
