<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Success</title>
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
        <h1 style="color: green;">Order Placed Successfully!</h1>
        <p>Your order has been successfully placed.</p>
        <p>Thank you for shopping with us!</p>
        <a href="home.jsp" class="btn btn-primary">Continue Shopping</a>
    </div>
    <%@ include file="footer.jsp" %>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/custom.js"></script>
</body>
</html>
