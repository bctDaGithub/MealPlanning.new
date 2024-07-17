

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="">
        <meta name="author" content="">

        <title>Meal Planing-Your Meals</title>

        <!-- CSS FILES -->
        <link rel="preconnect" href="https://fonts.googleapis.com">

        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap" rel="stylesheet">

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-icons.css" rel="stylesheet">

        <link rel="stylesheet" href="css/slick.css"/>
        <link rel="stylesheet" href="css/menuCustomer.css"/>

        <link href="css/tooplate-little-fashion.css" rel="stylesheet">

    </head>
    
    <body>

        <section class="preloader">
            <div class="spinner">
                <span class="sk-inner-circle"></span>
            </div>
        </section>
    
        <main>

            <%@ include file="navbar.jsp" %>

            <header class="site-header section-padding d-flex justify-content-center align-items-center">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-10 col-12">
                            <h1>
                                <span class="d-block text-primary">Choose your</span>
                                <span class="d-block text-dark">favorite foods</span>
                            </h1>
                        </div>
                    </div>
                </div>
            </header>
           <div class="meal-selection">
            <table>
                <thead>
                    <tr>
                        <th>Day</th>
                        <th>Morning</th>
                        <th>Afternoon</th>
                        <th>Evening</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="day" items="${['Thứ 2', 'Thứ 3', 'Thứ 4', 'Thứ 5', 'Thứ 6', 'Thứ 7', 'Chủ nhật']}">
                        <tr>
                            <td>${day}</td>
                            <td>
                                <select name="morningMeal">
                                    <option value="">Choose a meal</option>
                                    <c:forEach var="dish" items="${dishes}">
                                        <option value="${dish.id}">${dish.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <select name="afternoonMeal">
                                    <option value="">Choose a meal</option>
                                    <c:forEach var="dish" items="${dishes}">
                                        <option value="${dish.id}">${dish.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <select name="eveningMeal">
                                    <option value="">Choose a meal</option>
                                    <c:forEach var="dish" items="${dishes}">
                                        <option value="${dish.id}">${dish.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
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

    </body>
</html>

