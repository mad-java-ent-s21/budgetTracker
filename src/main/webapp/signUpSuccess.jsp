<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title" value="Search"/>


<html>
<head>
    <title>Sign Up Success</title>
    <jsp:include page="head.jsp" />
</head>

<body>
<%-- NAV BAR --%>
<jsp:include page="navbar.jsp" />
<jsp:include page="bodyTop.jsp" />

<div class="center-align">
<br>
<h4>Sign Up Success</h4>
<br>
<a href="userLogin.jsp" class="waves-effect waves-light btn">Log In</a>
</div>

<jsp:include page="scripts.jsp" />
<jsp:include page="bodyBottom.jsp" />
</body>
</html>
