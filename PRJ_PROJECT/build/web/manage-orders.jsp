<%--
    Document   : manage-orders
    Created on : Jul 16, 2024, 10:00:00 PM
    Author     : Cong Tuong
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="dto.Order"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Orders</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="css/slick.css"/>
    <link href="css/tooplate-little-fashion.css" rel="stylesheet">
    <style>
       body {
            font-family: 'Inter', sans-serif;
            background-color: #f8f9fa;
        }
        main {
            margin: 100px auto 50px auto;
            padding: 20px;
            background: white;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: rgb(247, 72, 20);
        }
        .table {
            margin-top: 20px;
        }
        .search-bar {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }
        .filter-checkboxes {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }
        .filter-checkboxes label {
            margin: 0 10px;
        }
        .btn-primary {
            background-color: rgb(247, 72, 20);
            border-color: rgb(247, 72, 20);
        }
        .btn-primary:hover {
            background-color: rgb(220, 50, 10);
            border-color: rgb(220, 50, 10);
        }
    </style>
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <main style="margin: 200px auto 150px auto">
        <div class="container mt-5">
            <div class="row">
                <div class="col-12">
                    <h1 style="color: rgb(247, 72, 20)" class="text-center">Manage Orders</h1>
                </div>
                <div class="col-12 mt-3">
                    <!-- Search and Filter Form -->
                    <form action="ManageOrdersServlet" method="get" class="mb-3">
                        <div class="form-row align-items-center">
                            <div class="col-auto">
                                <label class="sr-only" for="userId">User ID</label>
                                <input type="text" class="form-control mb-2" id="userId" name="userId" placeholder="Tìm theo UserID">
                            </div>
                            <div class="col-auto">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="statusPending" name="status" value="Pending">
                                    <label class="form-check-label" for="statusPending">Pending</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="statusProcessing" name="status" value="Processing">
                                    <label class="form-check-label" for="statusProcessing">Processing</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="statusCompleted" name="status" value="Completed">
                                    <label class="form-check-label" for="statusCompleted">Completed</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="statusCancelled" name="status" value="Cancelled">
                                    <label class="form-check-label" for="statusCancelled">Cancelled</label>
                                </div>
                            </div>
                            <div class="col-auto">
                                <button type="submit" class="btn btn-primary mb-2">Search</button>
                            </div>
                        </div>
                    </form>
                    <!-- Orders Table -->
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Order ID</th>
                                <th scope="col">User ID</th>
                                <th scope="col">Order Date</th>
                                <th scope="col">Total Amount</th>
                                <th scope="col">Status</th>
                                <th scope="col">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Order> allOrderList = (List<Order>) request.getAttribute("orderList");
                                if (allOrderList != null) {
                                    for (Order order : allOrderList) {
                            %>
                            <tr>
                                <td><%=order.getOrderId()%></td>
                                <td><%=order.getUserId()%></td>
                                <td><%=order.getOrderDate()%></td>
                                <td><%=order.getTotal()%></td>
                                <td><%=order.getStatus()%></td>
                                <td>
                                    <a href="main?action=view-order-details-admin&orderId=<%=order.getOrderId()%>" class="btn btn-primary btn-sm">View Details</a>
                                    <!-- Add other actions as needed -->
                                </td>
                            </tr>
                            <%
                                    }
                                } else {
                            %>
                            <tr>
                                <td colspan="6" class="text-center">No orders found.</td>
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
    <!-- Include any other JS files needed -->
</body>
</html>
