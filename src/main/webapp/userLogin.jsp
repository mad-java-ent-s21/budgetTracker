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

<div class="row">
<div class="log-form center-align col s6 push-s3">
    <h2>Login to your account</h2>
    <form action="login" method="post">
        <input id="userName" type="text" title="username" name="username" placeholder="username" required />
        <input id="password" type="password" title="password" name="password" placeholder="password" required />
        <button type="submit" class="btn">Login</button>
        <a class="signUp" href="signup.jsp">Sign Up</a>
    </form>
</div>
</div>
<jsp:include page="scripts.jsp" />
<jsp:include page="bodyBottom.jsp" />
</body>
</html>
