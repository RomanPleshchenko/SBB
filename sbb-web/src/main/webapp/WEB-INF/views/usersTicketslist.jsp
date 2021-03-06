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
        <jsp:param name="title" value="My tickets"/>
    </jsp:include>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/userTicketsPage.js"></script>
</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>

<input type="hidden" id="userSSO" value= ${pageContext.request.userPrincipal.name}>

<div class="container">
    <h2>List of tickets</h2>

    <table id="ticketTable" class="table">
        <thead>
        <tr>
            <th>tickets number</th>
            <th>plases number</th>
            <th>trains number</th>
            <th>destination station</th>
            <th>departure station</th>
            <th>departure time</th>
            <th>destination time</th>
        </tr>
        </thead>
    </table>
</div>

<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>
