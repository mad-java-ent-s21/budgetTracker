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


<div class="log-form">
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



</div>
<jsp:include page="scripts.jsp" />
</body>
</html>
