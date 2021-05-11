<%@ page import="edu.matc.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title" value="Search"/>


<html>
<head>
    <jsp:include page="head.jsp" />
</head>
<body>
<%-- NAV BAR --%>
<jsp:include page="navbar.jsp" />
<jsp:include page="bodyTop.jsp" />

<h1 class="center-align">Entries</h1>
<br>
<div class="row">
<%--    <div class="col s2 center-align"></div>--%>
<%--    <div class="col s10"></div>--%>
    <div class="col s2 push-s10 center-align">
        <!-- Modal Trigger -->
        <a class="waves-effect waves-light btn modal-trigger center-align purple" href="#exportCSVSearch">Export Data</a>

        <!-- Modal Structure -->
        <div id="exportCSVSearch" class="modal">
            <form id="exportCSV" method="post" action="https://www.googleapis.com/upload/drive/v2/files" >
                <h4>Export Data</h4>
                <label for="exportFile">File: </label>
                <input id="exportFile" name="exportFile" type="file" title="exportFile" required />
                <br>
                <button type="submit" class="btn purple">Export CSV to Google Drive</button>
                <a href="userEntry" type="button" class="btn">Cancel</a>
            </form>
        </div>
    </div>
</div>


<%
    User user = (User) session.getAttribute("user");
%>

<table id="userTable" class="display" cellspacing="0" width="100%">
    <thead>
    <th>Date</th>
    <th>Entry Name</th>
    <th>Value</th>
    <th>Type</th>
    <th>Category</th>
    <th></th>
    </thead>

    <tbody>

    <c:forEach var="entry" items="${entry}">
        <%--  TODO - adjust according to Category color  --%>
        <%--            <tr class="green">   --%>
        <tr>
            <td>
                    ${entry.date}
                <div style="display: none;">${entry.id}</div>
            </td>
            <td>
                    ${entry.entryName}
            </td>
            <td class="currency">
                    ${entry.value}
            </td>
            <td>
                    ${entry.entryType}
            </td>
            <td>
                    ${entry.categoryId.categoryName}
            </td>
            <td>
                <form id="editEntry" action="editEntry" method="get">
                    <input id="entryId" style="display: none; visibility: hidden;" name="entryId" value="${entry.id}">
                    <button type="submit" class="waves-effect waves-light btn-flat">Edit</button>
                </form>
                <form id="deleteEntry" action="deleteEntry" method="get">
                    <input id="entryIdDel" style="display: none; visibility: hidden;" name="entryId" value="${entry.id}">
                    <button type="submit" class="waves-effect waves-light red darken-1">Delete</button>
                </form>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="scripts.jsp" />
<jsp:include page="bodyBottom.jsp" />
</body>
</html>
