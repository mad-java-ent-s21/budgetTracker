<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/7/21
  Time: 5:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h4 class="center-align">Log-in Failed!</h4>
    <a href="userLogin.jsp" class="waves-effect waves-light btn">Log In</a>
    <a href="signup.jsp" class="waves-effect waves-light btn">Sign Up</a>
</div>

<jsp:include page="scripts.jsp" />
<jsp:include page="bodyBottom.jsp" />
</body>
</html>
