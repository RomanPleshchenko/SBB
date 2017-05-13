<%--qqqqqqqqqqqqqqqqqq--удалить%>
<%--
  Created by IntelliJ IDEA.
  User: РОМАН
  Date: 09.04.2017
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <jsp:include page="header.jsp" flush="true" >
        <jsp:param name="title" value="Select passenger"/>
    </jsp:include>
</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>


<div class="container">
    <h2>Please select a train and passenger</h2>

    <form:form method="GET" commandName="set" action="saveTicket-${idShedule}" class="box login">
        <fieldset class="boxBody">

            <label>Select passenger</label>
            <form:select path="id1">
                <form:option value="NONE" label="-- Please choose a passenger --"/>
                <form:options items="${passengers}" itemValue="id" itemLabel="fullName"/>
            </form:select>

            <footer>
                <input type="submit" class="btn btn-success" value="buy" tabindex="4">
            </footer>

        </fieldset>

    </form:form>

</div>


<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>