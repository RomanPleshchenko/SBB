<%--
  Created by IntelliJ IDEA.
  User: РОМАН
  Date: 07.04.2017
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <jsp:include page="header.jsp" flush="true" >
        <jsp:param name="title" value="Schedule"/>
    </jsp:include>
</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>

<div class="container">
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
            </tr>

        </c:forEach>
        </tbody>

    </table>
</div>

<%--<div class="container">--%>
<%--<h2>Please select a train and passenger</h2>--%>

<%--<form:form method="GET" commandName="set" action="saveTicket" class="box login">--%>
<%--<fieldset class="boxBody">--%>

<%--<label>Select passenger</label>--%>
<%--<form:select path="id1">--%>
<%--<form:option value="NONE" label="-- Please choose a passenger --"/>--%>
<%--<form:options items="${passengers}" itemValue="id" itemLabel="fullName"/>--%>
<%--</form:select>--%>

<%--<label>Select train</label>--%>
<%--<form:select path="id2">--%>
<%--<form:option value="NONE" label="-- Please choose a train --"/>--%>
<%--<form:options items="${schedule}" itemValue="id" itemLabel="showing"/>--%>
<%--</form:select>--%>

<%--<footer>--%>
<%--<input type="submit" class="btn btn-success" value="buy" tabindex="4">--%>
<%--</footer>--%>

<%--</fieldset>--%>

<%--</form:form>--%>

<%--</div>--%>



<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>
