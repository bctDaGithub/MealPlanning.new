<%-- 
    Document   : user-order-history
    Created on : Jul 17, 2024, 10:00:00 PM
    Author     : Cong Tuong
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="dto.Order"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="css/slick.css"/>
    <link href="css/tooplate-little-fashion.css" rel="stylesheet">
    <style>
        .main-content {
            margin: 200px auto 150px auto;
        }
        .table-container {
            margin-top: 20px;
        }
        .search-bar {
            margin-bottom: 20px;
        }
        .table td, .table th {
            vertical-align: middle;
        }
        .page-title {
            color: rgb(247, 72, 20);
        }
    </style>
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <main class="main-content">
        <div class="container mt-5">
            <div class="row">
                <div class="col-12">
                    <h1 class="text-center page-title">Order History</h1>
                </div>
                <div class="col-12 table-container">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Order ID</th>
                                <th scope="col">Order Date</th>
                                <th scope="col">Total Amount</th>
                                <th scope="col">Status</th>
                                <th scope="col">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                                List<Order> userOrderList = (List<Order>) request.getAttribute("userOrderList");
                                if (userOrderList != null) {
                                    for (Order order : userOrderList) {
                            %>
                            <tr>
                                <td><%=order.getOrderId()%></td>
                                <td><%=order.getOrderDate()%></td>
                                <td>$<%=order.getTotal()%></td>
                                <td><%=order.getStatus()%></td>
                                <td>
                                    <a href="main?action=view-order-details&orderId=<%=order.getOrderId()%>" class="btn btn-primary btn-sm">View Details</a>
                                </td>
                            </tr>
                            <%
                                    }
                                } else {
                            %>
                            <tr>
                                <td colspan="5" class="text-center">No orders found.</td>
                            </tr>
                            <% 
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </main>
    <%@ include file="footer.jsp" %>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
