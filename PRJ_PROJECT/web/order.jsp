<%-- 
    Document   : order.jsp
    Created on : Jul 15, 2024, 11:54:00 PM
    Author     : Cong Tuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dto.Dishes"%>
<%@page import="dao.DishDAO"%>
<%
    String dishIdParam = request.getParameter("dishId");
    if (dishIdParam != null) {
        int dishId = Integer.parseInt(dishIdParam);
        DishDAO dishDAO = new DishDAO();
        Dishes dish = dishDAO.getDishById(dishId);
        if (dish != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title style="color: rgb(247, 72, 20)"><%= dish.getName()%> - Order</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-icons.css" rel="stylesheet">
        <link href="css/tooplate-little-fashion.css" rel="stylesheet">
        <link href="css/order-style.css" rel="stylesheet"> 
        <style>
            .page-title {
                margin-top: 80px;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <main style="margin-bottom: 40px;">
            <div class="container mt-5">
                <div class="row">
                    <div class="col-12 page-title">
                        <h1 style="color: rgb(247, 72, 20)"><%= dish.getName()%></h1>
                    </div>
                    <div class="col-lg-8">
                        <div class="order-content">
                            <div class="dish-details">
                                <img src="<%= dish.getImagePath()%>" alt="<%= dish.getName()%>" class="dish-image">
                                <div class="dish-info">
                                    <h3 class="info-title">Description:</h3>
                                    <p><%= dish.getDescription()%></p>
                                    <h3 class="info-title">Calories:</h3>
                                    <p><%= dish.getCalories()%></p>
                                    <h3 class="info-title">Price:</h3>
                                    <p>$<%= dish.getEstimatedPrice()%></p>
                                    <h3 class="info-title">Ingredients:</h3>
                                    <p><%= dish.getIngredients()%></p>
                                    <h3 class="info-title">Method:</h3>
                                    <p><%= dish.getMethod()%></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="order-form">
                            <form action="main" method="post">
                                <input type="hidden" name="action" value="add-to-cart">
                                <input type="hidden" name="dishId" value="<%= dish.getId()%>">
                                <div class="form-group">
                                    <label for="quantity" class="form-label">Quantity:</label>
                                    <input type="number" id="quantity" name="quantity" class="form-control quantity-input" min="1" value="1" required>
                                </div>
                                <button type="submit" class="btn btn-order">Add to cart</button>
                            </form>
                        </div>
                    </div>
                </div>
                <%-- Thông báo thành công hoặc thất bại --%>
                <div class="row mt-3">
                    <div class="col-12">
                        <% if (request.getAttribute("addToCartSuccess") != null && (boolean) request.getAttribute("addToCartSuccess")) { %>
                            <div class="alert alert-success" role="alert">
                                Successfully added to cart!
                            </div>
                        <% } else if (request.getAttribute("addToCartSuccess") != null && !(boolean) request.getAttribute("addToCartSuccess")) { %>
                            <div class="alert alert-danger" role="alert">
                                Failed to add to cart!
                            </div>
                        <% } %>
                    </div>
                </div>
            </div>
        </main>

        <%@ include file="footer.jsp" %>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>
<%
        } else {
            // Handle dish not found
            out.println("<h1>Dish not found!</h1>");
        }
    } else {
        // Handle invalid dishId
        out.println("<h1>Invalid Dish ID!</h1>");
    }
%>

