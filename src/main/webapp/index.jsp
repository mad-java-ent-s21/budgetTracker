<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title" value="Search"/>


<html>
    <head>
        <title>Budget Tracker</title>
        <jsp:include page="head.jsp" />
    </head>

    <body>
        <%-- NAV BAR --%>
        <jsp:include page="navbar.jsp" />
        <jsp:include page="bodyTop.jsp" />
        <div class="row">
            <div class="col s10 push-s1">

        <h3 class="center-align">Welcome to the Budget Tracker!<br>
            Here you can track any expense and income.<br>
            Make your finance matter!</h3>

        <div class="center-align">
            <%
                if (session.getAttribute("user") == null) {
            %>
                <a href="userLogin.jsp" class="waves-effect waves-light btn">Log In</a>
                <a href="signup.jsp" class="waves-effect waves-light btn">Sign Up</a>
            <%
                } else {
            %>
                View your entries!!
            <%
                }
            %>
        </div>
        <jsp:include page="scripts.jsp" />
        <jsp:include page="bodyBottom.jsp" />
<%--            </div>--%>
<%--        </div>--%>
    </body>
</html>
