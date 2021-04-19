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

    <h1>Category</h1>

<%--    TODO Display categories for user   --%>
<%--    TODO Display per color chosen   --%>
<%--    Category Table for user   --%>
<table id="userTable" class="display" cellspacing="0" width="100%">
    <thead>
    <th>Category Name</th>
    <th>Description</th>
    <th>Color</th>
    </thead>

    <tbody>
    <c:forEach var="category" items="${category}">
        <tr>
            <td>
                    ${category.categoryName}
            </td>
            <td>
                    ${category.categoryDescription}
            </td>
            <td>
                    ${category.color}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="scripts.jsp" />
</body>
</html>