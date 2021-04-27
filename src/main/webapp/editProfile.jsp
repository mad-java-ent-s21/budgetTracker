<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title" value="Search"/>


<html>
<head>
    <title>Your Profile</title>
    <jsp:include page="head.jsp" />
</head>

<body>
<%-- NAV BAR --%>
<jsp:include page="navbar.jsp" />
<jsp:include page="bodyTop.jsp" />


<div class="log-form center-align">
    <h2>Your Profile</h2>

    <a href="userCategory" class="waves-effect waves-light btn">Customize Category</a>
    <br><br><br>

    <a href="" class="waves-effect waves-light btn">Edit Profile</a><br>
    <c:forEach var="user" items="${users}">--%>
        <p>Username: ${user.username}</p><br>
        <p>Name: ${user.firstName} ${user.lastName}</p><br>
        <p>Email: ${user.email}</p><br>
        <p>${user.birthdate}</p>
    </c:forEach>


    <%--    <%! String username=session.getAttribute("username"); %>--%>
    <form action="editinfo" method="post">
        <table>
            <tr>
                <td>Username: </td><td><input type="text" value="<%= session.getAttribute("username") %>" /></td>
            </tr>
            <tr>
                <td>Name: </td><td><input type="text" value="<%= session.getAttribute("name") %>" /></td>
            </tr>
        </table>
    </form>



</div>
<jsp:include page="scripts.jsp" />
<jsp:include page="bodyBottom.jsp" />
</body>
</html>
