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
                            <div class="col-lg-2"></div>
                            <div class="col-lg-6" style="text-align: center; margin-top: 20px; margin-bottom: 20px;padding-top: 20px"F>
                                <form action="managerAccount" method="post" style="display: flex; justify-content: center">
                                    <input name="valueSearch" value="${requestScope.searchValue != null ? requestScope.searchValue : ""}" id="searchId" type="text" oninput="searchByName()" placeholder="Search user name" style="width: 60%; padding: 4px 10px; border-radius: 15px">
                                    <button type="submit" style="border-radius: 50%; width: 40px; font-size: 18px; margin-left: 10px"><i class="fa fa-search"></i></button>
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
                                    <c:forEach items="${listUser}" var="u">
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
