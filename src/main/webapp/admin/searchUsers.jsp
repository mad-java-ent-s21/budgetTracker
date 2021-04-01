<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title" value="Search"/>


<html>
    <head>
        <jsp:include page="../head.jsp" />
    </head>

    <body>
        <%-- NAV BAR --%>
        <jsp:include page="../navbar.jsp" />
        <br>
        <a href = "searchUser">All Users</a>

        <%-- SCRIPTS --%>
        <jsp:include page="../scripts.jsp" />
    </body>
</html>
