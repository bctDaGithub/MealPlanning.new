<%-- 
    Document   : cancel-success
    Created on : Jul 17, 2024, 8:13:51 AM
    Author     : Cong Tuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cancel Success</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="css/bootstrap-icons.css" rel="stylesheet">
    <link href="css/tooplate-little-fashion.css" rel="stylesheet">
    <style>
        .container {
            margin-top: 50px;
        }
    </style>
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <div style="margin: 200px auto 200px auto" class="container">
        <h1 style="color: green;">Cancel Order Successfully!</h1>
        <p>Your order has been successfully cancel.</p>
        <p>Thank you for shopping with us!</p>
        <a href="home.jsp" class="btn btn-primary">Continue Shopping</a>
    </div>
    <%@ include file="footer.jsp" %>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/custom.js"></script>
</body>
</html>

