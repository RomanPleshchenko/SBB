<%--
  Created by IntelliJ IDEA.
  User: РОМАН
  Date: 05.04.2017
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <jsp:include page="header.jsp" flush="true" >
        <jsp:param name="title" value="routes"/>
    </jsp:include>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/routesPage.js"></script>
</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>



<div class="well well-sm">

    <center>
        <label>List of all routes</label>
    </center>

    <table id="routeTable" class="table">
        <thead>
        <tr>
            <th> </th>
            <th>route id</th>
            <th>route number</th>
            <th>connection</th>
        </tr>
        </thead>
    </table>

</div>

<center>
    <div id='msg'>
        <div id='attent'></div>
    </div>
</center>

<div class="well well-sm">

    <center>
        <label>Route composition</label>
    </center>

    <table id="routeCompositionTable" class="table">
        <thead>
        <tr>
            <th>destination station</th>
            <th>departure station</th>
            <th>destinationTime</th>
            <th>departureTime</th>
        </tr>
        </thead>
    </table>

</div>


<div class="well well-sm">

    <center>

        <input type="hidden" id="csrfToken" value="${_csrf.token}"/>
        <input type="hidden" id="headerName" value="${_csrf.headerName}"/>
        <div id = "btns" class="well well-sm">
        </div>
    </center>
</div>


<div class="well">
    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
    <a href="<c:url value='/newRoute' />">Add new route</a>
</div>


<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>
