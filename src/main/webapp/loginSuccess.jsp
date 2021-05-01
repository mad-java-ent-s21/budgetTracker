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
<jsp:include page="bodyTop.jsp" />

<div class="center-align">
    <br>
    <h4>Log in successful!</h4>
    <a href="index.jsp" class="waves-effect waves-light btn">Return Home</a>
</div>

<jsp:include page="scripts.jsp" />
<jsp:include page="bodyBottom.jsp" />
</body>
</html>