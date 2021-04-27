<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title" value="Search"/>

<html>
<head>
    <title>Login</title>
    <jsp:include page="head.jsp" />
</head>
<body>
<%-- NAV BAR --%>
<jsp:include page="navbar.jsp" />
<jsp:include page="bodyTop.jsp" />

<div class="row">
<div class="col s6 push-s3">
<FORM ACTION="j_security_check" METHOD="POST">
<%--    <TABLE>--%>
        User name: <INPUT TYPE="TEXT" NAME="j_username">
        Password: <INPUT TYPE="PASSWORD" NAME="j_password">
        <INPUT TYPE="SUBMIT" VALUE="Log In">
<%--        <a class="signUp" href="signup.jsp">Sign Up</a>--%>
<%--    </TABLE>--%>
</FORM>
<jsp:include page="scripts.jsp" />
<jsp:include page="bodyBottom.jsp" />
</div>
</div>
</body>
</html>
