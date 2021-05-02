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
    <div class="center-align">
        <a href="userEntry" class="waves-effect waves-light btn">Return to Entries</a>
    </div>
    <br><br>
    <form id="deleteEntry" action="deleteEntry" method="post" data-toggle="validator">
        <div class="center-align">
            <c:forEach var="entry" items="${entry}">
                <input id="entryId" name="entryId" type="number" title="entryId" value="${entry.id}" style="display: none;"/>
                <h4>Delete "${entry.entryName}" entry?</h4>
            </c:forEach>
            <br><br>
            <button type="submit" class="btn">Yes</button>
            <a href="userEntry" class="btn red">No</a>
        </div>
    </form>
</div>
<jsp:include page="scripts.jsp" />
<jsp:include page="bodyBottom.jsp" />
</body>
</html>