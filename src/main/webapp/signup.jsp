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
<jsp:include page="bodyTop.jsp" />

<div class="row">
<div class="log-form center-align col s6 push-s3">
    <h2>Create an account</h2>

    <form id="userSignUp" action="userSignUp" method="post" data-toggle="validator">
        <input id="username" name="username" type="text" title="username" placeholder="Username" required />
        <input id="email" name="email" type="text" title="email" placeholder="Email" required />
        <input id="firstName" name="firstName" type="text" title="firstName" placeholder="First Name" />
        <input id="lastName" name="lastName" type="text" title="lastName" placeholder="Last Name" />
        <input id="password" name="password" type="password" title="password" placeholder="Password" required />
        <button type="submit" class="btn">Create Account</button>
        <button type="reset" class="btn">Clear</button>
    </form>
</div>
</div>

<jsp:include page="scripts.jsp" />
<jsp:include page="bodyBottom.jsp" />
</body>
</html>
