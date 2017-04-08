<%--
  Created by IntelliJ IDEA.
  User: РОМАН
  Date: 05.04.2017
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <jsp:include page="header.jsp" flush="true" >
        <jsp:param name="title" value="Schedule"/>
    </jsp:include>
</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>

<div class="container">
    <h2>Schedule</h2>
    <table class="table">
        <thead>
        <tr>
            <th>train number</th>
            <th>capacity</th>
            <th>departure time</th>
            <th>destination time</th>
            <th>departure station</th>
            <th>destination station</th>
            <th>sold tickets</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${schedule}" var="dir">
            <tr>
                <td>${dir.train.number}</td>
                <td>${dir.train.capacity}</td>
                <td>${dir.departureTime}</td>
                <td>${dir.destinationTime}</td>
                <td>${dir.route.departureStation.name}</td>
                <td>${dir.route.destinationStation.name}</td>
                <td>${fn:length(dir.tickets)}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>
