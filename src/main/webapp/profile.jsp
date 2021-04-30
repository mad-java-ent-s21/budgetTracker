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
    <br>
    <a href="" class="waves-effect waves-light btn light-blue darken-2">Edit Profile</a>
    <a href="userCategory" class="waves-effect waves-light btn teal darken-2">Customize Category</a>
    <br><br>

    <div class="row">
        <div class="col s6 push-s3">
            <table>
            <c:forEach var="user" items="${user}">
                <tr>
                    <td>Username: </td><td>${user.userName}</td>
                </tr>
                <tr>
                    <td>Name: </td><td>${user.firstName} ${user.lastName}</td>
                </tr>
                <tr>
                    <td>Email: </td><td>${user.email}</td>
                </tr>
                <tr>
                    <td>Birthdate: </td><td>${user.birthdate}</td>
                </tr>
            </c:forEach>
            </table>
        </div>
    </div>
<%--    <%! String username=session.getAttribute("username"); %>--%>

    <%
//        String username = request.getParameter("username");
        HttpSession sessionAtt = request.getSession();

        if(session.getAttribute("user") != null) {
    %>

<%--            <form action="editinfo" method="post">--%>
<%--                <table>--%>
<%--                    <tr>--%>
<%--                        <td>Username: </td><td><input type="text" value="<%= session.getAttribute("user") %>" /></td>--%>
<%--                    </tr>--%>
<%--                </table>--%>
<%--            </form>--%>
            testing

        <%}
    %>

<%--    <form action="editinfo" method="post">--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <td>Username: </td><td><input type="text" value="<%= session.getAttribute("user") %>" /></td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form>--%>



</div>
<jsp:include page="scripts.jsp" />
<jsp:include page="bodyBottom.jsp" />
</body>
</html>
