<nav>
    <div class="nav-wrapper green darken-1">
        <a href="index.jsp" class="brand-logo ">Budget Tracker</a>

        <%
            if (session.getAttribute("user") != null) {
        %>
            <ul id="nav-mobile-user" class="right hide-on-med-and-down">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="userEntry">Entry</a></li>
                <li><a href="userProfile">Profile</a></li>
                <li><a href="logout">Log Out</a></li>
            </ul>

        <%-- Logged In Drop Down --%>
        <!-- Dropdown Trigger -->
        <!-- Dropdown Trigger -->
        <a class='dropdown-trigger hide-on-large-only right green darken-1' href='#' data-target='dropdownMenuLogin'><i class="material-icons medium">menu</i></a>

        <!-- Dropdown Structure -->
        <ul id='dropdownMenuLogin' class='dropdown-content'>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="userEntry">Entry</a></li>
            <li><a href="userProfile">Profile</a></li>
            <li><a href="logout">Log Out</a></li>
        </ul>
        <%
            } else {
        %>
        <ul id="nav-mobile-login" class="right hide-on-med-and-down">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="userLogin.jsp">Log In</a></li>
            <li><a href="signup.jsp">Sign Up</a></li>
        </ul>

        <%-- Logged Out Drop Down --%>
        <!-- Dropdown Trigger -->
        <a class='dropdown-trigger hide-on-large-only right green darken-1' href='#' data-target='dropdownMenu'><i class="material-icons medium">menu</i></a>

        <!-- Dropdown Structure -->
        <ul id='dropdownMenu' class='dropdown-content'>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="userLogin.jsp">Log In</a></li>
            <li><a href="signup.jsp">Sign Up</a></li>
        </ul>
        <%
            }
        %>
<%--        <ul id="nav-mobile-admin" class="right hide-on-med-and-down">--%>
<%--            <li><a href="index.jsp">Home</a></li>--%>
<%--            <li><a href="admin/admin.jsp">Admin</a></li>--%>
<%--            <li><a href="admin/searchUsers.jsp">Search Users</a></li>--%>
<%--        </ul>--%>
    </div>
</nav>
