<%--
    Document   : manage-orders
    Created on : Jul 16, 2024, 10:00:00 PM
    Author     : Your Name
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Orders</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Include any other CSS files needed -->
    <style>
        /* Add your custom styles here */
    </style>
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <main>
        <div class="container mt-5">
            <div class="row">
                <div class="col-12">
                    <h1 class="text-center">Manage Orders</h1>
                </div>
                <div class="col-12 mt-3">
                    <c:if test="${not empty requestScope.orderList}">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">Order ID</th>
                                    <th scope="col">Customer Name</th>
                                    <th scope="col">Order Date</th>
                                    <th scope="col">Total Amount</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.orderList}" var="order">
                                    <tr>
                                        <td>${order.id}</td>
                                        <td>${order.customerName}</td>
                                        <td>${order.orderDate}</td>
                                        <td>${order.totalAmount}</td>
                                        <td>${order.status}</td>
                                        <td>
                                            <a href="view-order-details.jsp?orderId=${order.id}" class="btn btn-primary btn-sm">View Details</a>
                                            <!-- Add other actions as needed -->
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                    <c:if test="${empty requestScope.orderList}">
                        <p>No orders found.</p>
                    </c:if>
                </div>
            </div>
        </div>
    </main>
    <%@ include file="footer.jsp" %>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <!-- Include any other JS files needed -->
</body>
</html>
