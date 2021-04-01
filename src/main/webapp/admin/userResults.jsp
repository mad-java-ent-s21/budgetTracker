<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title" value="Search"/>


<html>
<head>
    <jsp:include page="../head.jsp" />
</head>
    <body>
        <table id="userTable" class="display" cellspacing="0" width="100%">
            <thead>
                <th>Name</th>
                <th>User</th>
            </thead>

            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>
                                ${user.firstName} ${user.lastName}
                        </td>
                        <td>
                                ${user.userName}
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <jsp:include page="../scripts.jsp" />
    </body>
</html>
