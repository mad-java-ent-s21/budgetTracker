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


<div class="log-form">
    <h2>Login to your account</h2>
    <form>
        <input type="text" title="username" placeholder="username" />
        <input type="password" title="username" placeholder="password" />
        <button type="submit" class="btn">Login</button>
        <a class="signUp" href="#">Sign Up</a>
    </form>

</div>
<jsp:include page="scripts.jsp" />
</body>
</html>
