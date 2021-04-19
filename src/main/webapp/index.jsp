<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title" value="Search"/>


<html>
    <head>
        <jsp:include page="head.jsp" />
    </head>

    <body>
    <%-- NAV BAR --%>
    <jsp:include page="navbar.jsp" />

    <h3>Welcome to the Budget Tracker! Here you can track any expense and income. Make your finance matter!</h3>



    <jsp:include page="scripts.jsp" />
    </body>
</html>
