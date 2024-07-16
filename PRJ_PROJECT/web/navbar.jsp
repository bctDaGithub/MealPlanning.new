<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%
    String userPage = "sign-in.jsp";
    if (session != null && session.getAttribute("account") != null) {
        userPage = "profile.jsp"; // Nếu đã đăng nhập, chuyển đến trang profile
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
            <a href="<%= userPage%>" class="bi-person custom-icon me-3"></a>
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
                <a href="<%= userPage%>" class="user bi-person custom-icon me-3"></a>
                <a href="main?action=view-cart" class="bi-bag custom-icon"></a>
            </div>
        </div>
    </div>
</nav>
