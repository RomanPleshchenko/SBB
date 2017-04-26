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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <jsp:include page="header.jsp" flush="true" >
        <jsp:param name="title" value="Test list"/>
    </jsp:include>
</head>

<body>

<jsp:include page="navigation.jsp"></jsp:include>

<div class="container">
    <h2>List of trains</h2>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>route.name</th>
            <th>segment1</th>
            <th>segment2</th>
            <%--<th>routeCompositions</th>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td>${item.id}  </td>
                <td>${item.route.name}  </td>
                <td>${item.segment.departureStation.name}  </td>
                <td>${item.segment.destinationStation.name}  </td>
                <%--<td>${fn:length(item.routeCompositions)}</td>--%>
                <%--<td><a href="<c:url value='/delete-train-${train.number}' />" class="btn btn-success custom-width">delete</a></td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%--<div class="well">--%>
        <%--<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />--%>
        <%--<a href="<c:url value='/newTrain' />">Add new train</a>--%>
    <%--</div>--%>
</div>

<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>
