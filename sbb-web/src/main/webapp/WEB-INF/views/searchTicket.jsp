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

        <form id = "searchForm" class="box login">

            <label>Select station</label>

            <select select id = "station1" path="station1">
                <c:forEach items="${stations}" var="station">
                    <option value = ${station.id}> ${station.name}</option>
                </c:forEach>
            </select>
            -
            <select select id = "station2" path="station2">
                <c:forEach items="${stations}" var="station">
                    <option value = ${station.id}> ${station.name}</option>
                </c:forEach>
            </select>

            <br>

            <label><label>Select date</label></label>

            <input id="data1" path="data1" type = "date" /> - <input id="data2" path="data2" type = "date"/>

            <footer>
                <input id = "toFind" class="btn btn-success" value="to find" tabindex="4">
            </footer>

        </form>



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

        <div id='btns'>
            <div id='choosed'></div>
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
