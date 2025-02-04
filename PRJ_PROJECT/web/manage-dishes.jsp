<%--
    Document   : manage-orders
    Created on : Jul 16, 2024, 10:00:00 PM
    Author     : Your Name
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="dto.Dishes"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Manage Dishes</title>
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
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <main style="margin: 200px auto 150px auto">
            <div class="container mt-5">
                <div class="row">
                    <div class="col-12">
                        <h1 style="color: rgb(247, 72, 20)" class="text-center">Manage Dishes</h1>
                    </div>

                    <div class="col-12 mt-3">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">Dish ID</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%                        List<Dishes> allDishesList = (List<Dishes>) request.getAttribute("dishesList");
                                    if (allDishesList != null) {
                                        for (Dishes dish : allDishesList) {
                                %>
                                <tr>
                                    <td><%=dish.getId()%></td>
                                    <td><%=dish.getName()%></td>
                                    <td><%=dish.getEstimatedPrice()%></td>
                                    <td>
                                        <a href="view-order-details.jsp?orderId=${order.id}" class="btn btn-primary btn-sm">View Details</a>
                                        <!-- Add other actions as needed -->
                                    </td>
                                </tr>
                                <%
                                    }
                                } else {
                                %>
                            <div class="col-12">
                                <p>No dishes found.</p>
                            </div>
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
