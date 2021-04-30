<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title" value="Search"/>


<html>
<head>
    <title>Sign Up</title>
    <jsp:include page="head.jsp" />
</head>

<body>
<%-- NAV BAR --%>
<jsp:include page="navbar.jsp" />
<jsp:include page="bodyTop.jsp" />

<div class="row">
    <div class="log-form center-align col s6 push-s3">
        <h2>Add an entry</h2>

        <form id="addEntry" action="addNewEntry" method="post" data-toggle="validator">
            <input id="date" name="date" type="date" title="date" placeholder="Date" required />
            <br>
            <input id="entryName" name="entryName" type="text" title="entryName" placeholder="Entry Name" required />
            <br>
            <%--  Entry Type  List selection --%>
            <div>
                <select id="entryType" name="entryType">
                    <option value="entryType" disabled selected>Choose your entry type</option>
                    <option value="expense">Expense</option>
                    <option value="income">Income</option>
                </select>
                <label>Entry Type Selection</label>
            </div>
            <br>
            <input id="value" name="value" type="text" title="value" placeholder="Value" required />
            <br>
            <%--  Category selection --%>
            <div>
                <select id="categoryName" name="categoryName" class="select">
                    <option value="categoryName" disabled selected>Choose your category</option>

                    <c:forEach items="${category}" var="category">
                        <option value="${category.categoryName}">${category.categoryName}</option>
                    </c:forEach>

                </select>
                <label>Category Selection</label>
            </div>
            <br>
            <button type="submit" class="btn">Add</button>
            <button type="reset" class="btn">Clear</button>
        </form>
    </div>
</div>

<jsp:include page="scripts.jsp" />
<jsp:include page="bodyBottom.jsp" />
</body>
</html>
