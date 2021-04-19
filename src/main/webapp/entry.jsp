<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title" value="Search"/>


<html>
<head>
    <jsp:include page="head.jsp" />
</head>
<body>
    <h1>Entries</h1>

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


<%--    TODO Display entries for user   --%>
<%--    Entries Table for user   --%>
    <table id="userTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Entry Name</th>
        <th>Value</th>
        </thead>

        <tbody>
        <c:forEach var="entry" items="${entry}">
            <tr>
                <td>
                        ${entry.entry_name}
                </td>
                <td>
                        ${entry.value}
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <jsp:include page="scripts.jsp" />
</body>
</html>
