<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title" value="Search"/>


<html>
<head>
    <title>Admin</title>
    <jsp:include page="../head.jsp" />
</head>
<body>
    <%-- Nav Bar--%>
    <nav>
        <div class="nav-wrapper">
            <a href="../index.jsp" class="brand-logo">Budget Tracker</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="">Log Off</a></li>
            </ul>
        </div>
    </nav>

    <h1>Admin Page</h1>
    <a href="searchUsers.jsp">Search Users</a>

    <%-- SCRIPTS --%>
    <jsp:include page="../scripts.jsp" />
</body>
</html>
