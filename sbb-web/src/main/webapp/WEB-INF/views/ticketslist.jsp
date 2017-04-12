<%--
  Created by IntelliJ IDEA.
  User: РОМАН
  Date: 05.04.2017
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="header.jsp" flush="true" >
        <jsp:param name="title" value="Tickets"/>
    </jsp:include>
</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>

<div class="container">
    <h2>List of tickets</h2>
    <p>List of all sold tickets</p>
    <table class="table">
        <thead>
        <tr>
            <th>trains number</th>
            <th>departure time</th>
            <th>destination time</th>
            <th>departure station</th>
            <th>departure station</th>
            <th>passenger</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tickets}" var="ticket">
            <tr>
                <td>${ticket.schedule.train.number}</td>
                <td>${ticket.schedule.departureTimeInFormat}</td>
                <td>${ticket.schedule.destinationTimeInFormat}</td>
                <td>${ticket.schedule.route.departureStation.name}</td>
                <td>${ticket.schedule.route.destinationStation.name}</td>
                <td>${ticket.passenger.name} ${ticket.passenger.surname}</td>
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
