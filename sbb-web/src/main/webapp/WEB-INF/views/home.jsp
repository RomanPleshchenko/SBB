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


<div class="container">
    <h2>Find a train</h2>

    <form>
        <div class="form-group">
            <label for="sel1">Select departure station:</label>
            <select class="form-control" id="sel1">
                <c:forEach items="${stations}" var="station">
                    <option>${station.name}</option>
                </c:forEach>
            </select>

            <label for="sel1">Select destination station:</label>
            <select class="form-control" id="sel2">
                <c:forEach items="${stations}" var="station">
                    <option>${station.name}</option>
                </c:forEach>
            </select>
            <br>
        </div>

        <%--<input tabindex="3" title="Дата" size="16" id="date0" maxlength="10" type="text">--%>

    </form>
</div>


<jsp:include page="footer.jsp"/>
</body>
</html>
