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
        <jsp:param name="title" value="Schedule"/>
    </jsp:include>
</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>


<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Schedule </span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Schedule</th>
                <th width="100"></th>
                <th width="100"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${schedule}" var="dir">
                <tr>
                    <td>${dir.id}</td>
                    <td>${dir.trainId}</td>
                    <td>${dir.departureTime}</td>
                    <td>${dir.destinationTime}</td>
                    <td>${dir.routeId}</td>
                    <%--<td><a href="<c:url value='/delete-train-${train.number}' />" class="btn btn-success custom-width">delete</a></td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%--<div class="well">--%>
        <%--<a href="<c:url value='/newTrain' />">Add new train</a>--%>
    <%--</div>--%>

</div>
</body>



<jsp:include page="footer.jsp"/>
</body>
</html>
