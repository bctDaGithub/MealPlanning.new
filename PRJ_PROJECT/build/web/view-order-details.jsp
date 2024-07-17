<%-- view-order-details.jsp --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dto.Order"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Details</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="css/slick.css"/>
    <link href="css/tooplate-little-fashion.css" rel="stylesheet">
    <style>
        /* Add your custom styles here */
    </style>
    <script>
        function confirmCancel() {
            if (confirm("Are you sure you want to cancel this order?")) {
                document.getElementById("cancelForm").submit();
            }
        }
    </script>
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <main style="margin: 200px auto 150px auto">
        <div class="container mt-5">
            <div class="row">
                <div class="col-12">
                    <h1 style="color: rgb(247, 72, 20)" class="text-center">Order Details</h1>
                </div>
                <div class="col-12 mt-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Order Information</h5>
                            <% Order order = (Order) request.getAttribute("orderDetails"); %>
                            <% if (order != null) { %>
                                <p><strong>Order ID:</strong> <%= order.getOrderId() %></p>
                                <p><strong>User ID:</strong> <%= order.getUserId() %></p>
                                <p><strong>Order Date:</strong> <%= order.getOrderDate() %></p>
                                <p><strong>Total Amount:</strong> <%= order.getTotal() %></p>
                                <p><strong>Status:</strong> <%= order.getStatus() %></p>
                                
                                <!-- Cancel Order Button -->
                                <% if (order.getStatus().equalsIgnoreCase("Pending") || order.getStatus().equalsIgnoreCase("Processing")) { %>
                                    <form id="cancelForm" action="manage-order-status?action=cancelForCus" method="post" style="display: inline;">
                                        <input type="hidden" name="orderId" value="<%= order.getOrderId() %>">
                                        <button type="button" class="btn btn-danger" onclick="confirmCancel()">Cancel Order</button>
                                    </form>
                                <% } %>
                            <% } else { %>
                                <p>Order details not found.</p>
                            <% } %>
                        </div>
                    </div>
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
