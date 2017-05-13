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
            <th>route name</th>
            <th>departure time</th>
            <th>destination time</th>
            <th>number of station</th>
            <th>action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${schedule}" var="dir">

            <tr>
                <td>${dir.train.number}</td>
                <td>${dir.route.number} ${dir.route.name}</td>
                <td>${dir.departureTimeInFormat}</td>
                <td>${dir.destinationTimeInFormat}</td>
                <td>${fn:length(dir.route.routeCompositions)+1}</td>
                <c:if test="${dir.active}">
                    <td><a href="<c:url value='/make-not-active-dir-${dir.id}' />" class="btn btn-danger">make not active</a></td>
                </c:if>
                <c:if test="${dir.active!=true}">
                    <td><a href="<c:url value='/make-active-dir-${dir.id}' />" class="btn btn-success custom-width">make active</a></td>
                </c:if>
                <c:if test="${dir.composed!=true}">
                    <td><a href="<c:url value='/compose-free-sites-${dir.id}' />" class="btn btn-success custom-width">compose free sites</a></td>
                </c:if>
            </tr>

        </c:forEach>
        </tbody>
    </table>


    <div id = "imaps">

    </div>

</div>

<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>

