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
    <h4>Fail to add a category.</h4>
    <p>Category name has to be unique.</p>
    <a href="userCategory" class="waves-effect waves-light btn">Go to Categories</a>
</div>

<jsp:include page="scripts.jsp" />
<jsp:include page="bodyBottom.jsp" />
</body>
</html>