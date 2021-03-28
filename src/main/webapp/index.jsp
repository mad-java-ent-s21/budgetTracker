<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<c:set var="title" value="Search"/>

<html>
<body>
<h1>Budget Tracker</h1>
<a href="admin/admin.jsp">Admin</a>
<a href="entry.jsp">Entry</a>
<a href="searchUsers.jsp">Search</a>
<div class="log-form">
    <h2>Login to your account</h2>
    <form>
        <input type="text" title="username" placeholder="username" />
        <input type="password" title="username" placeholder="password" />
        <button type="submit" class="btn">Login</button>
        <a class="signUp" href="#">Sign Up</a>
    </form>



<%--  TABLE TO DISPLAY USERS  --%>
    <table id="userTable" class="display" cellspacing="0" width="100%">
        <thead>
            <th>Name</th>
            <th>User</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.userName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
