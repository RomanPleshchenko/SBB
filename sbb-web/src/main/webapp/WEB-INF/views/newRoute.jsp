<%--
  Created by IntelliJ IDEA.
  User: РОМАН
  Date: 06.04.2017
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <jsp:include page="header.jsp" flush="true" >
        <jsp:param name="title" value="New train"/>
    </jsp:include>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/routesPage.js"></script>
</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>

<label>Number</label>
<input id="routesNumber" path="routesNumber" />

<label>connection</label>
<input id="routesName" path="routesName" />

<input type="hidden" id="csrfToken" value="${_csrf.token}"/>
<input type="hidden" id="headerName" value="${_csrf.headerName}"/>

<input id = "saveRoute" class="btn btn-success" value="save  route" tabindex="4" type="button">



<jsp:include page="footer.jsp"/>
</body>
</html>
