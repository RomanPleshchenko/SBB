<%--
  Created by IntelliJ IDEA.
  User: РОМАН
  Date: 05.04.2017
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <jsp:include page="header.jsp" flush="true" >
        <jsp:param name="title" value="Home"/>
    </jsp:include>
</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>

    <img src= "/static/images/train.jpg"  width="1500" height="500">

<jsp:include page="footer.jsp"/>
</body>
</html>
