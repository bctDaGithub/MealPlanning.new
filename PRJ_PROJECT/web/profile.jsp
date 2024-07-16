<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="">
        <meta name="author" content="">

        <title>Profile Page</title>

        <!-- CSS FILES -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-icons.css" rel="stylesheet">
        <link rel="stylesheet" href="css/slick.css"/>
        <link href="css/tooplate-little-fashion.css" rel="stylesheet">
        <link href="css/profile.css" rel="stylesheet">
    </head>

    <body>
        <main>
            <%@ include file="navbar.jsp" %>
            <div class="wrapper bg-white mt-sm-5">
                <h4 class="pb-4 border-bottom">Account settings</h4>
                <c:if test="${not empty statusMessage}">
                    <h5 style="color:green">${statusMessage}</h5>
                </c:if>

                <div class="py-2">
                    <form id="form-edit" action="profile" method="post"> 
                            <div class="row py-2 col-md-12 pt-md-0 pt-3">
                                <label for="username">User Name</label>
                                <input type="text" class="input_type bg-light form-control" name="username" value="${sessionScope.account.userName}" readOnly>
                            </div>
                            <div class="row py-2 col-md-12 pt-md-0 pt-3">
                                <label for="fullname">Full Name</label>
                                <input type="text" class="input_type bg-light form-control" name="fullname" value="${sessionScope.account.fullName}" readOnly>
                                <div class="error"></div>
                            </div>
                            <div class="row py-2 col-md-12 pt-md-0 pt-3">
                                <label for="email">Email Address</label>
                                <input type="text" class="input_type bg-light form-control" name="email" value="${sessionScope.account.email}" readOnly>
                                <div class="error"></div>
                            </div>
                            <div class="row py-2 col-md-12 pt-md-0 pt-3">
                                <label for="roleid">Role</label>
                                <input type="text" class="input_type bg-light form-control" name="roleid" value="${sessionScope.account.roleID ==1? "Admin" : "Customer"}" readOnly>
                            </div>
                            <div class="row py-2 col-md-12 pt-md-0 pt-3">
                                <label for="phone">Phone Number</label>
                                <input type="text" class="input_type bg-light form-control" name="phone" value="${sessionScope.account.phone}" readOnly>
                                <div class="error"></div>
                            </div>
                            <div class="row py-2 col-md-12 pt-md-0 pt-3">
                                <label for="address">Address</label>
                                <input type="text" class="input_type bg-light form-control" name="address" value="${sessionScope.account.address}" readOnly>
                                <div class="error"></div>
                            </div>
                                <div class="row py-2 col-md-12 pt-md-0 pt-3" id="lang">
                                <label for="birthday">Birthday</label>
                                <input type="date" class="input_type bg-light form-control" name="birthday" value="${sessionScope.account.birthdate}" readOnly>
                            </div>
                        <div>
                            <button class="btn btn-primary mr-3" style="margin-top: 10px" id="edit" type="button" onclick="changeType(this)">Edit</button>
                        </div>
                    </form>
                </div>
                <div class="d-sm-flex align-items-center justify-content-end pt-3 border-top" id="logout">
                    <div class="ml-auto">
                        <button class="btn danger" type="button" onclick="confirmLogout()">Log Out</button>
                    </div>
                </div>
            </div>
        </main>

        <%@ include file="footer.jsp" %>

        <!-- JAVASCRIPT FILES -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/Headroom.js"></script>
        <script src="js/jQuery.headroom.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/custom.js"></script>
        <script src="js/profile.js"></script>
    </body>
</html>
