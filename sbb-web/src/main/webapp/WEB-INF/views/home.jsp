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

    <%--<form method="post" action="findTrainByParameter">--%>
        <%--<div class="form-group">--%>
            <%--<label for="sel1">Select departure station:</label>--%>
            <%--<select class="form-control" id="sel1">--%>
                <%--<c:forEach items="${stations}" var="station">--%>
                    <%--<option>${station.name}</option>--%>
                <%--</c:forEach>--%>
            <%--</select>--%>

            <%--<label for="sel1">Select destination station:</label>--%>
            <%--<select class="form-control" id="sel2">--%>
                <%--<c:forEach items="${stations}" var="station">--%>
                    <%--<option>${station.name}</option>--%>
                <%--</c:forEach>--%>
            <%--</select>--%>
            <%--<h4>look for</h4>--%>
            <%--<input name="date1" TYPE = date>-<input name="date2" TYPE = date>--%>
        <%--</div>--%>

        <%--<footer>--%>
            <%--<input type="submit" class="btn btn-success" value="to find" tabindex="4">--%>
        <%--</footer>--%>
    <%--</form>--%>


    <form:form method="POST" commandName="parametersForSearch" action="findTrainByParameter" class="box login">
        <fieldset class="boxBody">

            <form:label path="station1">station1:</form:label>
            <form:input path="station1" />

            <form:label path="station2">station2:</form:label>
            <form:input path="station2"/>

            <form:label path="data1">data1:</form:label>
            <form:input path="data1"/>

            <form:label path="data2">data2:</form:label>
            <form:input path="data2"/>

        </fieldset>

        <footer>
            <input type="submit" class="btnLogin" value="to find" tabindex="4">
        </footer>

    </form:form>

</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
