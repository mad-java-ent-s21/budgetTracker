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
    <h2>Your Profile</h2>

    <%--    User Table   --%>
    <%--    <table id="userTable" class="display" cellspacing="0" width="100%">--%>
    <%--        <thead>--%>
    <%--        <th>Name</th>--%>
    <%--        <th>User</th>--%>
    <%--        </thead>--%>

    <%--        <tbody>--%>
    <%--        <c:forEach var="user" items="${users}">--%>
    <%--            <tr>--%>
    <%--                <td>--%>
    <%--                        ${user.firstName} ${user.lastName}--%>
    <%--                </td>--%>
    <%--                <td>--%>
    <%--                        ${user.userName}--%>
    <%--                </td>--%>
    <%--            </tr>--%>
    <%--        </c:forEach>--%>
    <%--        </tbody>--%>
    <%--    </table>--%>

        User Table
        <table id="userTable" class="display" cellspacing="0" width="100%">
            <thead>
            <th>Username</th>
            <th>Name</th>
            <th>Email</th>
            <th>Birthdate</th>
            </thead>

            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>
                            ${user.username}
                    </td>
                    <td>
                            ${user.firstName} ${user.lastName}
                    </td>
                    <td>
                            ${user.email}
                    </td>
                    <td>
                            ${user.birthdate}
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

</div>
<jsp:include page="scripts.jsp" />
</body>
</html>
