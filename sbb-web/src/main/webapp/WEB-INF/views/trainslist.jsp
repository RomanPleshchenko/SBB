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
    <script type="text/javascript" src="/static/js/trainsScripts.js"></script>
</head>

<body>

<jsp:include page="navigation.jsp"></jsp:include>

<div class="container">
    <h2>List of trains</h2>
    <table class="table">
        <thead>
        <tr>
            <th> </th>
            <th>number</th>
            <th>capacity</th>
            <th>action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${trains}" var="train">
            <tr>
                <td> <input id = trainRadioId${train.id} type=radio name=trainRadio value=${train.id} </td>
                <td>${train.number}  </td>
                <td>${train.capacity}  </td>
                <td><input id = "del${train.number}" class="btn btn-danger" value="delete" type="button" tabindex="4"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="well well-sm">

        <center>
            <label>Trains composition</label>
        </center>

        <table id="trainsCompositionTable" class="table">
            <thead>
            <tr>
                <th>Car</th>
            </tr>
            </thead>
        </table>

        <center>
            <input type="hidden" id="csrfToken" value="${_csrf.token}"/>
            <input type="hidden" id="headerName" value="${_csrf.headerName}"/>
            <div id='btns'>
            </div>
        </center>
    </div>


    <div class="well">
        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
        <a href="<c:url value='/newTrain' />">Add new train</a>
    </div>
</div>

<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>
