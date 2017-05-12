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
            <li><a href="/stations">stations</a></li>
            <%--<sec:authorize access="hasRole('ROLE_ADMIN')">--%>
                <li><a href="/schedule">schedule</a></li>
                <li><a href="/userslist">users</a></li>
            <%--</sec:authorize>--%>
            <li><a href="/searchTicket">search ticket</a></li>
            <li><a href="/testList">test list</a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">

            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Log in</a></li>
            </c:if>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li><a ><span class="glyphicon glyphicon-user"></span>User : ${pageContext.request.userPrincipal.name}</a></li>
                <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
            </c:if>

        </ul>
    </div>
</nav>

</body>
</html>
