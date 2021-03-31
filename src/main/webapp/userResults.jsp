<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/28/21
  Time: 1:23 AM
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

        <%-- SCRIPTS --%>
        <jsp:include page="scripts.jsp" />
    </body>
</html>
