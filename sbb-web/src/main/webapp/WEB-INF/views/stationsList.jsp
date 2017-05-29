<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Stations</title>

    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>

    <script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>

    <script type="text/javascript" src="/static/js/stationsPagination.js"></script>
    
</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>

<form:form action="" method="GET">
    <h2>List of station<br><br></h2>
    <table id="stationsList" class="table" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>Name</th>
        </tr>
        </thead>
    </table>
    </td></tr></table>
</form:form>

<div class="well">
    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
    <a href="<c:url value='/newStation' />">Add new station</a>
</div>


</body>
</html>