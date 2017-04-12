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
        <jsp:param name="title" value="Search ticket"/>
    </jsp:include>
</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>


<div class="container">
    <h2>Find a train</h2>

    <form:form method="get" commandName="parametersForSearch" action="scheduleByParameters" class="box login">
        <fieldset class="boxBody">

            <label>Select station</label>
            <form:select path="station1">
                <form:option value="NONE" label="-- Please choose a departure station --"/>
                <form:options items="${stations}" itemValue="id" itemLabel="name"/>
            </form:select>
            -
            <form:select path="station2">
                <form:option value="NONE" label="-- Please choose a destination  station --"/>
                <form:options items="${stations}" itemValue="id" itemLabel="name"/>
            </form:select>

            <br>

            <label><label>Select date</label></label>

            <form:input path="data1" type = "date" /> - <form:input path="data2" type = "date"/>

            <footer>
                <input type="submit" class="btn btn-success" value="to find" tabindex="4">
            </footer>

        </fieldset>

    </form:form>

</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
