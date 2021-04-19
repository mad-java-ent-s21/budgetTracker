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

    <h1>Entries</h1>

<%--    TODO Display entries for user   --%>
<%--    TODO Display based on color of category  --%>
<%--    Entries Table for user   --%>
    <table id="userTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Date</th>
        <th>Entry Name</th>
        <th>Value</th>
        <th>Type</th>
        <th>Category</th>
        </thead>

        <tbody>
        <c:forEach var="entry" items="${entry}">

<%--  TODO - "if statement" that adjust according to Category color  --%>
<%--            <tr class="green">   --%>
            <tr>
                <td>
                        ${entry.date}
                </td>
                <td>
                        ${entry.entryName}
                </td>
                <td>
                        ${entry.value}
                </td>
                <td>
                        ${entry.entryType}
                </td>
                <td>
                        ${entry.categoryId.categoryName}
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <jsp:include page="scripts.jsp" />
</body>
</html>
