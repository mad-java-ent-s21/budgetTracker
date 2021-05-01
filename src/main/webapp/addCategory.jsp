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
        <h2>Add a category</h2>

        <form id="addNewCategory" action="addNewCategory" method="post" data-toggle="validator">
            <input id="categoryName" name="categoryName" type="text" title="categoryName" placeholder="Category Name" required />
            <br>
            <textarea id="categoryDescription" class="materialize-textarea" name="categoryDescription" placeholder="Description" required></textarea>
            <br>
            <%--  Colors List selection --%>
            <div>
                <select id="color" name="color">
                    <option value="entryType" disabled selected>Choose your category color</option>
                    <option value="#f44336">Red</option>
                    <option value="#e91e63">Pink</option>
                    <option value="#9c27b0">Purple</option>
                    <option value="#673ab7">Deep Purple</option>
                    <option value="#3f51b5">Indigo</option>
                    <option value="#2196f3">Blue</option>
                    <option value="#03a9f4">Light Blue</option>
                    <option value="#00bcd4">Cyan</option>
                    <option value="#009688">Teal</option>
                    <option value="#4caf50">Green</option>
                </select>
                <label>Color Selection</label>
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
