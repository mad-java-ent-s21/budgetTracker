<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title" value="Search"/>


<html>
    <head>
        <title>User Search</title>
        <jsp:include page="../head.jsp" />
    </head>

    <body>
        <%-- NAV BAR --%>
        <nav>
            <div class="nav-wrapper">
                <a href="../index.jsp" class="brand-logo">Budget Tracker</a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="../admin/admin.jsp">Return to Admin Page</a></li>
                </ul>
            </div>
        </nav>
        <br>
        <a href = "searchUser">All Users</a>

        <%-- SCRIPTS --%>
        <jsp:include page="../scripts.jsp" />
    </body>
</html>
