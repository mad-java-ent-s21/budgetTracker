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
<div>
    <br>
    <a href="userEntry" class="waves-effect waves-light btn">Return to Entries</a>
    <br>
    <form id="deleteEntry" action="deleteEntry" method="post" data-toggle="validator">
        <div class="center-align">
            <c:forEach var="entry" items="${entry}">
                <span>Delete "${entry.entryName}" entry?</span>
            </c:forEach>
            <br>
            <button type="submit" class="btn">Yes</button>
            <a href="userEntry" class="btn red">No</a>
        </div>
    </form>
</div>
<jsp:include page="scripts.jsp" />
<jsp:include page="bodyBottom.jsp" />
</body>
</html>