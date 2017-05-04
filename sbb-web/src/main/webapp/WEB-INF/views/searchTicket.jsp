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

    <script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
    <script type="text/javascript" src="/static/js/scheduleScripts.js"></script>
</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>


<div class="container">
    <h2>Find a train</h2>

    <%--<form:form method="post" commandName="parametersForSearch" action="scheduleByParameters" class="box login">--%>
    <form:form id = "searchForm" method="post" commandName="parametersForSearch" action="" class="box login">
        <fieldset class="boxBody">
            <td>${error} <br></td>

            <label>Select station</label>
            <form:select id = "station1" path="station1">
                <form:option value="NONE" label="-- Please choose a departure station --"/>
                <form:options items="${stations}" itemValue="id" itemLabel="name"/>
            </form:select>
            -
            <form:select id = "station2" path="station2">
                <form:option value="NONE" label="-- Please choose a destination  station --"/>
                <form:options items="${stations}" itemValue="id" itemLabel="name"/>
            </form:select>

            <br>

            <label><label>Select date</label></label>

            <form:input id="data1" path="data1" type = "date" /> - <form:input id="data2" path="data2" type = "date"/>

            <%--<footer>--%>
                <%--<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />--%>
                <%--<input type="submit" class="btn btn-success" value="to find" tabindex="4">--%>
            <%--</footer>--%>

            <footer>
                <%--<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />--%>
                <input id = "toFind" class="btn btn-success" value="to find" tabindex="4">
            </footer>

        </fieldset>

    </form:form>

    <table id="scheduleTable" class="table" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>train number</th>
            <th>route name</th>
            <th>departure time</th>
            <th>destination time</th>
            <th>number of station</th>
            <th>action</th>
        </tr>
        </thead>
    </table>

</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
