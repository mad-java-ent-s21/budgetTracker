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
    <form id="editEntry" action="editEntry" method="post" data-toggle="validator">
        <input id="entryDate" name="entryDate" type="date" title="entryDate" value="${entry.date}" required />
        <label for="entryDate">Date</label>

        <input id="entryName" name="entryName" type="text" title="entryName" value="${entry.entryName}" required />
        <label for="entryName">Entry Name</label>

        <input id="value" name="value" type="number" title="value" value="${entry.value}" />
        <label for="value">Value</label>

        <input id="entryType" name="entryType" type="text" title="entryType" value="${entry.entryType}" />
        <label for="entryType">Entry Type</label>

        <input id="categoryName" name="categoryName" type="text" title="categoryName" value="${entry.categoryId.categoryName}" required />
        <label for="categoryName">Category</label>

<%--        <div class="modal-footer">--%>
            <button type="submit" class="btn">Save</button>
            <button type="reset" class="btn">Clear</button>
<%--        </div>--%>
    </form>
</div>
<jsp:include page="scripts.jsp" />
<jsp:include page="bodyBottom.jsp" />
</body>
</html>
