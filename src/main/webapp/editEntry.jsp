<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div>
    <br>
    <div class="center-align">
        <a href="userEntry" class="waves-effect waves-light btn">Return to Entries</a>
    </div>
    <br>
    <form id="editEntry" action="editEntry" method="post">
        <c:forEach var="entry" items="${entry}">
            <input id="entryId" name="entryId" type="number" title="entryId" value="${entry.id}" style="display: none;"/>

            <input id="entryDate" name="entryDate" type="date" title="entryDate" value="${entry.date}" required />
            <label for="entryDate">Date</label>

            <input id="entryName" name="entryName" type="text" title="entryName" value="${entry.entryName}" required />
            <label for="entryName">Entry Name</label>

            <%--  Entry Type  List selection --%>
            <div>
                <select id="entryType" name="entryType" required>
                    <option value="entryType" disabled>Choose your entry type</option>
                    <option value="Expense">Expense</option>
                    <option value="Income">Income</option>
                </select>
                <label>Entry Type Selection</label>
            </div>

            <input id="value" name="value" type="number" title="value" value="${entry.value}" required/>
            <label for="value">Value</label>

            <%--  Category selection --%>
            <div>
                <select id="categoryName" name="categoryName" class="select" required>
                    <option value="categoryName" disabled>Choose your category</option>

                    <c:forEach items="${category}" var="category">
                        <option value="${category.categoryName}">${category.categoryName}</option>
                    </c:forEach>

                </select>
                <label>Category Selection</label>
            </div>
        </c:forEach>

        <br>
        <div class="center-align">
            <button type="submit" class="btn">Save</button>
            <button type="reset" class="btn">Clear</button>
        </div>
    </form>
</div>
<jsp:include page="scripts.jsp" />
<jsp:include page="bodyBottom.jsp" />
</body>
</html>
