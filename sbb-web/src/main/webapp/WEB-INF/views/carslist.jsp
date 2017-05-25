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
        <jsp:param name="title" value="Train list"/>
    </jsp:include>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/carScript.js"></script>
</head>

<body>

<jsp:include page="navigation.jsp"></jsp:include>

<input type="hidden" id="csrfToken" value="${_csrf.token}"/>
<input type="hidden" id="headerName" value="${_csrf.headerName}"/>

<div class="container">
    <h2>List of cars</h2>
    <table id = "carsTable" class="table">
        <thead>
        <tr>
            <th>number</th>
            <th>capacity</th>
            <th>class</th>
            <th> </th>
        </tr>
        </thead>
    </table>

    <div class="well">
        <label>Number</label>
        <%--<input id="carsNumber" path="carsNumber" />--%>
        <input id="carsNumber" path="carsNumber" type="number"/>
        <label>car type</label>
        <select select id = "carsClassId" path="carsClass">
            <c:forEach items="${carsClasses}" var="carsClass">
                <option value = ${carsClass.id}> ${carsClass.name}</option>
            </c:forEach>
        </select>

        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

        <button id = "SaveNewCar" type="button" class="btn btn-success"> Save new car </button>
    </div>
</div>

<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>
