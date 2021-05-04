<%@ page import="edu.matc.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title" value="Search"/>


<html>
<head>
    <title>Entries</title>
    <jsp:include page="head.jsp" />
</head>
<body>
    <%-- NAV BAR --%>
    <jsp:include page="navbar.jsp" />
    <jsp:include page="bodyTop.jsp" />

    <h1 class="center-align">Entries</h1>
        <br>
<%--    TODO Buttons for all the controls in ENTRY | grid --%>
    <div class="row">
        <!-- Modal Trigger -->
        <a class="waves-effect waves-light btn modal-trigger center-align" href="#entrySearch">Search</a>

        <!-- Modal Structure -->
        <div id="entrySearch" class="modal">
            <form id="searchEntries" method="get" action="searchEntry" >
                <label for="startDate">Start Date: </label>
                <input id="startDate" name="startDate" type="date" title="startDate" placeholder="Start Date" required />
                <br>
                <label for="endDate">End Date:</label>
                <input id="endDate" name="endDate" type="date" title="endDate" placeholder="End Date" required />
                <br>
<%--                &lt;%&ndash;  Entry Type  List selection &ndash;%&gt;--%>
<%--                <div>--%>
<%--                    <select id="entryType" name="entryType" required>--%>
<%--                        <option value="entryType" disabled selected>Choose your entry type</option>--%>
<%--                        <option value="all">All</option>--%>
<%--                        <option value="Expense">Expense</option>--%>
<%--                        <option value="Income">Income</option>--%>
<%--                    </select>--%>
<%--                    <label>Entry Type Selection</label>--%>
<%--                </div>--%>
<%--                <br>--%>
<%--                <div>--%>
<%--                    <select id="categoryName" name="categoryName" class="select" required>--%>
<%--                        <option value="categoryName" disabled selected>Choose your category</option>--%>
<%--                        <option value="all">All</option>--%>

<%--                        <c:forEach items="${category}" var="category">--%>
<%--                            <option value="${category.categoryName}">${category.categoryName}</option>--%>
<%--                        </c:forEach>--%>

<%--                    </select>--%>
<%--                    <label>Category Selection</label>--%>
<%--                </div>--%>
<%--                <br>--%>
                <button type="submit" class="btn">Search By Dates</button>
            </form>
        </div>
    </div>

<%--        <form method="get" action="searchEntry" >--%>
<%--&lt;%&ndash;            <div class="col s3 center-align">&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;            <!-- Dropdown Trigger -->&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;            <a class="dropdown-trigger btn" href="#" data-target="dropdownMonth">Month<i class="material-icons right">arrow_drop_down</i></a>&ndash;%&gt;--%>

<%--&lt;%&ndash;&lt;%&ndash;            <!-- Dropdown Structure -->&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;            <ul id="dropdownMonth" class="dropdown-content">&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">All</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">January</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">February</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">March</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">April</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">May</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">June</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">July</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">August</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">September</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">October</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">November</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">December</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </ul>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <div class="input-field col s12">&ndash;%&gt;--%>
<%--                <select id="month" name="month" required>--%>
<%--                    <option value="" disabled selected>Choose your option</option>--%>
<%--                    <option value="all">All</option>--%>
<%--                    <option value="january">January</option>--%>
<%--                    <option value="february">February</option>--%>
<%--                    <option value="march">March</option>--%>
<%--                    <option value="april">April</option>--%>
<%--                    <option value="may">May</option>--%>
<%--                    <option value="june">June</option>--%>
<%--                    <option value="july">July</option>--%>
<%--                    <option value="august">August</option>--%>
<%--                    <option value="september">September</option>--%>
<%--                    <option value="october">October</option>--%>
<%--                    <option value="november">November</option>--%>
<%--                    <option value="december">December</option>--%>
<%--                </select>--%>
<%--                <label>Month</label>--%>
<%--&lt;%&ndash;            </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </form>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div class="col s3 center-align">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <!-- Dropdown Trigger -->&ndash;%&gt;--%>
<%--&lt;%&ndash;            <a class='dropdown-trigger btn' href='#' data-target='dropdownYear'>Year<i class="material-icons right">arrow_drop_down</i></a>&ndash;%&gt;--%>

<%--&lt;%&ndash;            <!-- Dropdown Structure -->&ndash;%&gt;--%>
<%--&lt;%&ndash;            <ul id='dropdownYear' class='dropdown-content'>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">All</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">2021</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">2022</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">2023</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </ul>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <div class="input-field col s12">&ndash;%&gt;--%>
<%--                <select id="year" name="year" required>--%>
<%--                    <option value="" disabled selected>Choose your option</option>--%>
<%--                    <option value="all">All</option>--%>
<%--                    <option value="2021">2021</option>--%>
<%--                    <option value="2022">2022</option>--%>
<%--                    <option value="2023">2023</option>--%>
<%--                </select>--%>
<%--                <label>Year</label>--%>
<%--&lt;%&ndash;            </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div class="col s4"></div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div class="col s3 center-align">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <!-- Dropdown Trigger -->&ndash;%&gt;--%>
<%--&lt;%&ndash;            <a class='dropdown-trigger btn' href='#' data-target='dropdownEntryType'>Entry Type<i class="material-icons right">arrow_drop_down</i></a>&ndash;%&gt;--%>

<%--&lt;%&ndash;            <!-- Dropdown Structure -->&ndash;%&gt;--%>
<%--&lt;%&ndash;            <ul id='dropdownEntryType' class='dropdown-content'>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">All</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">Expense</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">Income</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </ul>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <div class="input-field col s12">&ndash;%&gt;--%>
<%--                <select id="entryType" name="entryType" required>--%>
<%--                    <option value="" disabled selected>Choose your option</option>--%>
<%--                    <option value="all">All</option>--%>
<%--                    <option value="expense">Expense</option>--%>
<%--                    <option value="income">Income</option>--%>
<%--                </select>--%>
<%--                <label>Entry Type</label>--%>
<%--&lt;%&ndash;            </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div class="col s3 center-align">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <!-- Dropdown Trigger -->&ndash;%&gt;--%>
<%--&lt;%&ndash;            <a class='dropdown-trigger btn' href='#' data-target='dropdownCategory'>Category<i class="material-icons right">arrow_drop_down</i></a>&ndash;%&gt;--%>

<%--&lt;%&ndash;            <!-- Dropdown Structure -->&ndash;%&gt;--%>
<%--&lt;%&ndash;            <ul id='dropdownCategory' class='dropdown-content'>&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                TODO look through user's categories created  &ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">All</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">House Hold</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">Paycheck</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#!">Food</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </ul>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <div class="input-field col s12">&ndash;%&gt;--%>
<%--                <select id="category" name="category" required>--%>
<%--                    <option value="" disabled selected>Choose your option</option>--%>
<%--                    <option value="All">All</option>--%>
<%--                    <c:forEach items="${category}" var="category">--%>
<%--                        <option value="${category.categoryName}">${category.categoryName}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--                <label>Category</label>--%>
<%--&lt;%&ndash;            </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>
<%--        <br><br>--%>
<%--&lt;%&ndash;        <div class="center-align">&ndash;%&gt;--%>
<%--            <button type="submit" class="btn">Search</button>--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>
<%--        </form>--%>
<%--    </div>--%>

    <br>
    <div class="row">
        <div class="col s2 center-align">
            <a href="entryAddition" class="waves-effect waves-light btn yellow black-text">Add Entry</a>
        </div>
        <div class="col s8"></div>
        <div class="col s2 center-align">
            <a class="waves-effect waves-light btn disabled">Export Data</a>
        </div>
    </div>

<%--    TODO Display based on color of category  --%>
<%--    Entries Table for user   --%>

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

<%--        TODO --not working-- trying query the user's data --%>
<%--        <sql:query dataSource="${Entry}" var="userEntry">--%>
<%--            SELECT * from entry WHERE userId = <% session.getAttribute("user"); %>;--%>
<%--        </sql:query>--%>
        <c:forEach var="entry" items="${entry}">

<%--  TODO - "if statement" that adjust according to Category color  --%>
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
