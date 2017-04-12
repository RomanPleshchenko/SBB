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

<%--так не работает--%>
<%--<img src="../resources/train.jpg">--%>
<%--пока будет ссылка--%>
<p><img src="https://1001freedownloads.s3.amazonaws.com/vector/thumb/319927/52c052487cc5383f69cd62b57f972994-locomotive-vector.jpg"  width="1000" height="500"><p>

<jsp:include page="footer.jsp"/>
</body>
</html>
