<%--
  Created by IntelliJ IDEA.
  User: РОМАН
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
        <jsp:param name="title" value="Stations list"/>
    </jsp:include>
</head>

<body>

<jsp:include page="navigation.jsp"></jsp:include>

<div class="container">
    <h2>List of station</h2>
    <table class="table">
        <thead>
        <tr>
            <th>name</th>
            <th>action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${stations}" var="station">
            <tr>
                <td>${station.name}  </td>
                <td><a href="<c:url value='/go-schedule-${station.name}' />" class="btn btn-success custom-width">look scheule</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="well">
        <a href="<c:url value='/newStation' />">Add new station</a>
    </div>
</div>


<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>
