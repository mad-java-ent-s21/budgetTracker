<%@ page import="edu.matc.entity.User" %>
<%@ page import="edu.matc.entity.Entry" %>
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
        <div class="col s3 center-align">
<%--            <!-- Dropdown Trigger -->--%>
            <a class="dropdown-trigger btn" href="#" data-target="dropdownMonth">Month<i class="material-icons right">arrow_drop_down</i></a>

<%--            <!-- Dropdown Structure -->--%>
            <ul id="dropdownMonth" class="dropdown-content">
                <li><a href="#!">All</a></li>
                <li><a href="#!">January</a></li>
                <li><a href="#!">February</a></li>
                <li><a href="#!">March</a></li>
                <li><a href="#!">April</a></li>
                <li><a href="#!">May</a></li>
                <li><a href="#!">June</a></li>
                <li><a href="#!">July</a></li>
                <li><a href="#!">August</a></li>
                <li><a href="#!">September</a></li>
                <li><a href="#!">October</a></li>
                <li><a href="#!">November</a></li>
                <li><a href="#!">December</a></li>
            </ul>
<%--            <form>--%>
<%--            <div class="input-field col s12">--%>
<%--                <select>--%>
<%--                    <option value="" disabled selected>Choose your option</option>--%>
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
<%--            </div>--%>
<%--            </form>--%>
        </div>
        <div class="col s3 center-align">
            <!-- Dropdown Trigger -->
            <a class='dropdown-trigger btn' href='#' data-target='dropdownYear'>Year<i class="material-icons right">arrow_drop_down</i></a>

            <!-- Dropdown Structure -->
            <ul id='dropdownYear' class='dropdown-content'>
                <li><a href="#!">All</a></li>
                <li><a href="#!">2021</a></li>
                <li><a href="#!">2022</a></li>
                <li><a href="#!">2023</a></li>
            </ul>
<%--            <div class="input-field col s12">--%>
<%--                <select>--%>
<%--                    <option value="" disabled selected>Choose your option</option>--%>
<%--                    <option value="2021">2021</option>--%>
<%--                    <option value="2022">2022</option>--%>
<%--                    <option value="2023">2023</option>--%>
<%--                </select>--%>
<%--                <label>Year</label>--%>
<%--            </div>--%>
        </div>
<%--        <div class="col s4"></div>--%>
        <div class="col s3 center-align">
            <!-- Dropdown Trigger -->
            <a class='dropdown-trigger btn' href='#' data-target='dropdownEntryType'>Entry Type<i class="material-icons right">arrow_drop_down</i></a>

            <!-- Dropdown Structure -->
            <ul id='dropdownEntryType' class='dropdown-content'>
                <li><a href="#!">All</a></li>
                <li><a href="#!">Expense</a></li>
                <li><a href="#!">Income</a></li>
            </ul>
<%--            <div class="input-field col s12">--%>
<%--                <select>--%>
<%--                    <option value="" disabled selected>Choose your option</option>--%>
<%--                    <option value="expense">Expense</option>--%>
<%--                    <option value="income">Income</option>--%>
<%--                </select>--%>
<%--                <label>Entry Type</label>--%>
<%--            </div>--%>
        </div>
        <div class="col s3 center-align">
            <!-- Dropdown Trigger -->
            <a class='dropdown-trigger btn' href='#' data-target='dropdownCategory'>Category<i class="material-icons right">arrow_drop_down</i></a>

            <!-- Dropdown Structure -->
            <ul id='dropdownCategory' class='dropdown-content'>
<%--                TODO look through user's categories created  --%>
                <li><a href="#!">All</a></li>
                <li><a href="#!">House Hold</a></li>
                <li><a href="#!">Paycheck</a></li>
                <li><a href="#!">Food</a></li>
            </ul>
<%--            <div class="input-field col s12">--%>
<%--                <select>--%>
<%--                    <option value="" disabled selected>Choose your option</option>--%>
<%--                    <option value="house hold">House Hold</option>--%>
<%--                    <option value="paycheck">Paycheck</option>--%>
<%--                    <option value="food">Food</option>--%>
<%--                </select>--%>
<%--                <label>Category</label>--%>
<%--            </div>--%>
        </div>
    </div>
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
                    <%--   TODO potentially use MODAL to popup display for edit or delete   --%>
<%--                    <a class="waves-effect waves-teal btn-flat">Edit</a>   <a class="waves-effect waves-light btn red">Delete</a>--%>
                    <a class="waves-effect waves-light btn-flat modal-trigger" href="#modalEdit">Edit</a>
                    <a class="waves-effect waves-light btn red modal-trigger" href="#modalDelete">Delete</a>

                    <!-- Modal Structure -->
                    <div id="modalEdit" class="modal">
                        <div class="modal-content">
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

                                <div class="modal-footer">
                                    <button type="submit" class="btn">Save</button>
                                    <button type="reset" class="btn">Clear</button>
                                </div>
                            </form>
                        </div>
                    </div>

                    <!-- Modal Structure -->
                    <div id="modalDelete" class="modal">
                        <div class="modal-content">
                            <h4>Delete your entry?</h4>
                            <p>You may not recover your entry after deleting.</p>
                        </div>
                        <div class="modal-footer">
                            <a href="#" class="modal-close waves-effect waves-green btn-flat">Yes</a>
                            <a href="#" class="modal-close waves-effect waves-green btn-flat">No</a>
                        </div>
                    </div>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <!-- Modal Trigger -->
<%--    <a class="waves-effect waves-light btn modal-trigger" href="#modal1">Modal</a>--%>

    <!-- Modal Structure -->
<%--    <div id="modalEdit" class="modal">--%>
<%--        <div class="modal-content">--%>
<%--            <h4>Modal Header</h4>--%>
<%--            <p>A bunch of text</p>--%>
<%--        </div>--%>
<%--        <div class="modal-footer">--%>
<%--            <a href="#!" class="modal-close waves-effect waves-green btn-flat">Agree</a>--%>
<%--        </div>--%>
<%--    </div>--%>

    <jsp:include page="scripts.jsp" />
    <jsp:include page="bodyBottom.jsp" />
</body>
</html>
