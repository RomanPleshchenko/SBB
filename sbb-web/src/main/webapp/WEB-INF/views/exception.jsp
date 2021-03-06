<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<jsp:include page="header.jsp" flush="true" >
		<jsp:param name="404" value="404"/>
	</jsp:include>
</head>

<body>
	<jsp:include page="navigation.jsp"></jsp:include>

    <div class="container">
        <div class="panel panel-danger">
            <div class="panel-heading">Error message:</div>
            <div class="panel-body">
                <c:choose>
                    <c:when test="${!empty exception.message}">
                        ${exception.message}
                    </c:when>
                    <c:otherwise>
                        Something went wrong :(
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>

</body>
</html>