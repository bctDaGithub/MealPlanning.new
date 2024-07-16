<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%
    String userPage = "sign-in.jsp";
    boolean isAdmin = false;

    if (session != null && session.getAttribute("account") != null) {
        userPage = "profile.jsp";
        Object account = session.getAttribute("account");
        if (account != null) {
            try {
                int roleID = Integer.parseInt(account.getClass().getMethod("getRoleID").invoke(account).toString());
                isAdmin = (roleID == 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
%>
<nav class="navbar navbar-expand-lg">
    <div class="container">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <a class="navbar-brand" href="index.jsp">
            <strong><span>Meal</span> Planing</strong>
        </a>

        <div class="d-lg-none">
            <% if (isAdmin) { %>
                <div class="dropdown">
                    <a href="#" class="bi bi-tv custom-icon me-3 dropdown-toggle" id="adminDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"></a>
                    <ul class="dropdown-menu" aria-labelledby="adminDropdown">
                        <li><a class="dropdown-item" href="managerUser.jsp">Manage Users</a></li>
                        <li><a class="dropdown-item" href="otherFunction1.jsp">Other Function 1</a></li>
                        <li><a class="dropdown-item" href="otherFunction2.jsp">Other Function 2</a></li>
                    </ul>
                </div>
            <% } %>
            <a href="<%= userPage %>" class="bi-person custom-icon me-3"></a>
            <a href="product-detail.jsp" class="bi-bag custom-icon"></a>
        </div>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mx-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="about.jsp">Menu</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="main?action=list-dishes">Foods</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="products.jsp">Your Meals</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact.jsp">Contact</a>
                </li>
            </ul>

            <div class="d-none d-lg-block">
                <% if (isAdmin) { %>
                    <div class="dropdown custom-icon me-3">
                        <a href="#" class="bi bi-tv custom-icon" id="adminDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"></a>
                        <ul class="dropdown-menu" aria-labelledby="adminDropdown">
                            <li><a class="dropdown-item" href="managerUser.jsp">Manage Users</a></li>
                            <li><a class="dropdown-item" href="#">Other Function 1</a></li>
                            <li><a class="dropdown-item" href="#">Other Function 2</a></li>
                        </ul>
                    </div>
                <% } %>
                <a href="<%= userPage %>" class="user bi-person custom-icon me-3"></a>
                <a href="product-detail.jsp" class="bi-bag custom-icon"></a>
            </div>
        </div>
    </div>
</nav>
