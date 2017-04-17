<%--
  Created by IntelliJ IDEA.
  User: РОМАН
  Date: 05.04.2017
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">SBB</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/trains">trains</a></li>
            <li><a href="/tickets">tickets</a></li>
            <li><a href="/schedule">schedule</a></li>
            <li><a href="/stations">stations</a></li>

            <sec:authorize access="hasRole('ADMIN')">
                <li><a href="/stations">stations!!!</a></li>
            </sec:authorize>

            <li><a href="/searchTicket">search ticket</a></li>
        </ul>
        <%--<form class="navbar-form navbar-left">--%>
            <%--<div class="form-group">--%>
                <%--<input type="text" class="form-control" placeholder="Search">--%>
            <%--</div>--%>
            <%--<button type="submit" class="btn btn-default">Submit</button>--%>
        <%--</form>--%>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>

</body>
</html>
