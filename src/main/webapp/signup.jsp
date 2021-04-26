<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title" value="Search"/>


<html>
<head>
    <title>Sign Up</title>
    <jsp:include page="head.jsp" />
</head>

<body>
<%-- NAV BAR --%>
<jsp:include page="navbar.jsp" />

<%--  TODO - create sign up controller  --%>
<div class="log-form">
    <h2>Create an account</h2>

    <form id="userSignUp" action="${pageContext.request.contextPath}/userSignUp" method="post" data-toggle="validator">
        <input type="text" title="userName" placeholder="Username" />
        <input type="text" title="email" placeholder="Email" />
        <input type="text" title="firstName" placeholder="First Name" />
        <input type="text" title="lastName" placeholder="Last Name" />
        <input type="password" title="password" placeholder="Password" />
        <button type="submit" class="btn">Create Account</button>
        <button type="reset" class="btn">Clear</button>
    </form>
</div>

<jsp:include page="scripts.jsp" />
</body>
</html>
