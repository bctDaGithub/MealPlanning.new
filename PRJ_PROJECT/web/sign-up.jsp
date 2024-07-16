
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="">
        <meta name="author" content="">

        <title>Sign Up Page</title>

        <!-- CSS FILES -->
        <link rel="preconnect" href="https://fonts.googleapis.com">

        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap" rel="stylesheet">

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-icons.css" rel="stylesheet">

        <link rel="stylesheet" href="css/slick.css"/>

        <link href="css/tooplate-little-fashion.css" rel="stylesheet">
        

    </head>
    
    <body>

        <section class="preloader">
            <div class="spinner">
                <span class="sk-inner-circle"></span>
            </div>
        </section>
    
        <main>
            <nav class="navbar navbar-expand-lg">
                <div class="container">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <strong class="navbar-brand" style="font-weight: bold" ><span>Meal</span> Planing</strong>
                </div>
            </nav>
            <section class="sign-in-form section-padding">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-8 mx-auto col-12">

                            <h1 class="hero-title text-center mb-5">Sign Up</h1>

                            <div class="row">
                                <div class="col-lg-8 col-11 mx-auto">
                                    <!--Sign Up Form -->
                                    <form id="signup-form" class="signup-form" action="register" role="form" method="post">
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

                                        <div class="form-floating  my-4">
                                            <input type="date" name="birthday" id="birthday" class="form-control" placeholder="">
                                            <div class="error"></div>
                                            <label for="birthday">Your Birthday</label>
                                        </div>

                                        <div class="form-floating">
                                            <input type="password" name="password" id="password" class="form-control" placeholder="Password">
                                            <div class="error"></div>
                                            <label for="password">Password</label>
                                            
                                        </div>

                                        <div class="form-floating  my-4">
                                            <input type="password" name="confirm_password" id="confirm_password" class="form-control" placeholder="">
                                            <div class="error"></div>
                                            <label for="confirm_password">Password Confirmation</label>
                                        </div>

                                        <button type="submit" class="btn custom-btn form-control mt-4 mb-3">
                                            Create account
                                        </button>

                                        <p class="text-center">Already have an account?<a href="sign-in.jsp" class="signin-button"> Sign In</a></p>
                                    </form>

                                </div>
                            </div>
                            
                        </div>

                    </div>
                </div>
            </section>

        </main>

        <footer class="site-footer">
            <div class="container">
                <div class="row">

                    <div class="col-lg-3 col-10 me-auto mb-4">
                        <h4 class="text-white mb-3"><a href="index.jsp">Meal</a> Planing</h4>
                        <p class="copyright-text text-muted mt-lg-5 mb-4 mb-lg-0">Copyright © 2024 <strong>Meal Planing</strong></p>
                        <br>
                        <p class="copyright-text">Designed by <a href="" target="_blank"></a></p>
                    </div>

                    <div class="col-lg-3 col-4">
                        <h5 class="text-white mb-3">Social</h5>

                        <ul class="social-icon">

                            <li><a href="#" class="social-icon-link bi-youtube"></a></li>

                            <li><a href="#" class="social-icon-link bi-whatsapp"></a></li>

                            <li><a href="#" class="social-icon-link bi-instagram"></a></li>

                            <li><a href="#" class="social-icon-link bi-skype"></a></li>
                        </ul>
                    </div>

                </div>
            </div>
        </footer>

        <!-- JAVASCRIPT FILES -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/Headroom.js"></script>
        <script src="js/jQuery.headroom.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/custom.js"></script>
        <script src="js/signup.js"></script>

    </body>
</html>



