<%--
  Created by IntelliJ IDEA.
  User: РОМАН
  Date: 10.04.2017
  Time: 2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <jsp:include page="header.jsp" flush="true" >
        <jsp:param name="title" value="Notification"/>
    </jsp:include>
</head>
<body>

${message}

<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>
