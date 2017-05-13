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

    <%--<script src="<c:url value="/static/js/jquery.min.js"/>"></script>--%>
    <%--<script src="<c:url value="/static/js/jquery.tooltip.min.js"/>"></script>--%>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/scheduleScripts.js"></script>
</head>
<body>

    <jsp:include page="navigation.jsp"></jsp:include>

    <div class="container">
        <h2>Find a train</h2>

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

                <footer>
                    <input id = "toFind" class="btn btn-success" value="to find" tabindex="4">
                </footer>

            </fieldset>

        </form:form>

        <table id="scheduleTable" class="table" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th> </th>
                <th>train</th>
                <th>route</th>
                <th>departure time</th>
                <th>destination time</th>
                <th>number of station</th>
                <th>tickets count</th>
            </tr>
            </thead>
        </table>

    </div>

    <center>

        <input type="hidden" id="userName" value= ${pageContext.request.userPrincipal.name}>

        <div id = "imaps" >

        </div>

        <div id='choosed'></div>

        <div id='btns'>
            <div id='btnBuy'></div>
        </div>

    </center>

    <br>
    <br>
    <br>
    <br>

    <jsp:include page="footer.jsp"/>
</body>
</html>
