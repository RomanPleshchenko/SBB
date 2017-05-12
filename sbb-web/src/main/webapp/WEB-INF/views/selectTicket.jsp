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
        <jsp:param name="title" value="Select ticket"/>
    </jsp:include>

    <script src="<c:url value="/static/js/jquery.min.js"/>"></script>
    <script type="text/javascript" src="/static/js/setFreeSite.js"></script>

</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>

<input type="hidden" id="st1" value= ${st1}>
<input type="hidden" id="st2" value= ${st2}>
<input type="hidden" id="dirId" value= ${dirId}>
<input type="hidden" id="routeId" value= ${routeId}>
<input type="hidden" id="userName" value= ${pageContext.request.userPrincipal.name}>

<div id = "imaps">

</div>

<div id='choosed'></div>
<div id='btnBuy'></div>


<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>
