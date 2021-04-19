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

<FORM ACTION="j_security_check" METHOD="POST">
<%--    <TABLE>--%>
        User name: <INPUT TYPE="TEXT" NAME="j_username">
        Password: <INPUT TYPE="PASSWORD" NAME="j_password">
        <INPUT TYPE="SUBMIT" VALUE="Log In">
<%--        <a class="signUp" href="signup.jsp">Sign Up</a>--%>
<%--    </TABLE>--%>
</FORM>


</body>
</html>
