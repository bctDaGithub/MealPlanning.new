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
            <div class="container pt-4" style="max-width: 1200px; margin-top: 80px;">
                <section class="mb-4">
                    <div class="card">
                        <div class="row">
                            <div class="col-sm-4" style="text-align: center; margin-top: 20px; margin-bottom: 20px; padding-top: 20px">
                                <h3 class="mb-0"><strong>Manage Account</strong></h3>
                            </div>
                            <h5 style="color: red">${requestScope.error}</h5>
                            <h5 style="color: green">${requestScope.successfully}</h5>
                            <div class="col-lg-2"></div>
                            <div class="col-lg-6" style="text-align: center; margin-top: 20px; margin-bottom: 20px; padding-top: 20px">
                                <form action="managerAccount" method="post" style="display: flex; justify-content: center; align-items: center;">
                                    <input name="valueSearch" value="${requestScope.searchValue != null ? requestScope.searchValue : ""}" id="searchId" type="text" oninput="searchByName()" placeholder="Search user name" style="width: 60%; padding: 4px 10px; border-radius: 15px">
                                    <button type="submit" style="border-radius: 50%; width: 40px; font-size: 18px; margin-left: 10px"><i class="bi bi-search fa fa-search"></i></button>
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addAccountModal" style="margin-left: 10px;">Add</button>
                                </form>
                            </div>
                        </div>
                        <div class="card-body" style="padding: 0">
                            <div class="table-responsive">
                                <table class="table table-hover text-nowrap">
                                    <thead>
                                        <tr>
                                            <th class="text_page_head">Full name</th>
                                            <th class="text_page_head">Username</th>
                                            <th class="text_page_head">Email</th>
                                            <th class="text_page_head">Address</th>
                                            <th class="text_page_head">Role</th>
                                            <th class="text_page_head">Phone</th>
                                            <th class="text_page_head">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:if test="${empty listUser}">
                                            <tr>
                                                <td colspan="7">No users found.</td>
                                            </tr>
                                        </c:if>
                                        <c:forEach items="${requestScope.listUser}" var="u">
                                            <tr>
                                                <td>${u.fullName}</td>
                                                <td>${u.userName}</td>
                                                <td>${u.email}</td>
                                                <td>${u.address}</td>
                                                <td>${u.roleID}</td>
                                                <td>${u.phone}</td>
                                                <td>
                                                    <a href="#">Edit</a> |
                                                    <a href="#">Delete</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </main>
        <%@ include file="footer.jsp" %>

        <!-- Add Account Modal -->
        <div class="modal fade" id="addAccountModal" tabindex="-1" aria-labelledby="addAccountModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addAccountModalLabel">Add Account</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form id="addAccount" class="addAccount" action="addaccount" role="form" method="post">

                            <div class="form-floating">
                                <input type="text" name="username" id="username" class="form-control" placeholder="">
                                <div class="error"></div>
                                <label for="username">Enter Your UserName</label>
                            </div>

                            <div class="form-floating my-4">
                                <input type="text" name="fullname" id="fullname" class="form-control" placeholder="">
                                <div class="error"></div>
                                <label for="fullname">Enter Your FullName</label>
                            </div>

                            <div class="form-floating">
                                <input type="text" name="email" id="email" class="form-control" placeholder="">
                                <div class="error"></div>
                                <label for="email">Enter Your Email</label>
                            </div>

                            <div class="form-floating my-4">
                                <input type="text" name="adress" id="adress" class="form-control" placeholder="" required>
                                <div class="error"></div>
                                <label for="adress">Enter Your Adress</label>
                            </div>

                            <div class="form-floating">
                                <input type="text" name="telephone" id="telephone" class="form-control" placeholder="">
                                <div class="error"></div>
                                <label for="telephone">Enter Your Phone Number</label>
                            </div>

                            <div class="form-floating my-4">
                                <input type="date" name="birthday" id="birthday" class="form-control" placeholder="">
                                <div class="error"></div>
                                <label for="birthday">Your Birthday</label>
                            </div>

                            <div class="form-floating">
                                <input type="password" name="password" id="password" class="form-control" placeholder="Password">
                                <div class="error"></div>
                                <label for="password">Password</label>
                            </div>

                            <div class="form-floating my-4">
                                <input type="password" name="confirm_password" id="confirm_password" class="form-control" placeholder="">
                                <div class="error"></div>
                                <label for="confirm_password">Password Confirmation</label>
                            </div>

                            <div class="form-floating">
                                <input name="roleId" value="1" type="checkbox" class="form-check-input" id="isAdmin">
                                <label class="form-check-label" for="isAdmin">Admin</label>
                            </div>

                            <div class="form-group my-4">
                                <button type="submit" class="btn btn-primary btn-block">Register</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- JAVASCRIPT FILES -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/Headroom.js"></script>
        <script src="js/jQuery.headroom.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/custom.js"></script>
        <script src="js/addAccount.js"></script>
    </body>
</html>
