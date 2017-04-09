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
        <jsp:param name="title" value="results"/>
    </jsp:include>
</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>

<div class="container">
    <h2>Find a train</h2>

    <form:form method="POST" commandName="set" action="saveTicket" class="box login">
        <fieldset class="boxBody">

            <label>Select passenger</label>
            <form:select path="id1">
                <form:option value="NONE" label="-- Please choose a passenger --"/>
                <form:options items="${passengers}" itemValue="id" itemLabel="fullName"/>
            </form:select>

            <%--<label>Select station</label>--%>
            <%--<form:select path="station1">--%>
                <%--<form:option value="NONE" label="-- Please choose a departure station --"/>--%>
                <%--<form:options items="${stations}" itemValue="id" itemLabel="name"/>--%>
            <%--</form:select>--%>
            <%-----%>
            <%--<form:select path="station2">--%>
                <%--<form:option value="NONE" label="-- Please choose a destination  station --"/>--%>
                <%--<form:options items="${stations}" itemValue="id" itemLabel="name"/>--%>
            <%--</form:select>--%>

            <%--<br>--%>

            <%--<label><label>Select date</label></label>--%>

            <%--<form:input path="data1" type = "date" /> - <form:input path="data2" type = "date"/>--%>

            <footer>
                <input type="submit" class="btn btn-success" value="buy" tabindex="4">
            </footer>

        </fieldset>

    </form:form>

</div>


=====================================================================================
=====================================================================================
=====================================================================================


    <div class="container">
        <h2>Please select an option</h2>
        <table class="table">
            <thead>
            <tr>
                <th>train number</th>
                <th>departure time</th>
                <th>destination time</th>
                <th>departure station</th>
                <th>destination station</th>
                <th>capacity</th>
                <th>sold tickets</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${schedule}" var="dir">
                <tr>
                    <td>${dir.train.number}</td>
                    <td>${dir.departureTime}</td>
                    <td>${dir.destinationTime}</td>
                    <td>${dir.route.departureStation.name}</td>
                    <td>${dir.route.destinationStation.name}</td>
                    <td>${dir.train.capacity}</td>
                    <td>${fn:length(dir.tickets)}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <footer>
        <input type="submit" class="btnLogin" value="buy" tabindex="4">
    </footer>






<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>
