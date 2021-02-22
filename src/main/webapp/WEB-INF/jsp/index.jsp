<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!doctype html>
<html>
    <head>
        <jsp:include page="standard_html_header.jsp" />
        <link href="fixed_header.css" rel="stylesheet">
        <link href="fixed_footer.css" rel="stylesheet">
        <link href="index.css" rel="stylesheet">
        <title>Snack vendor</title>

        <style>
            .form-signin {
              width: 100%;
              max-width: 400px;
              padding: 15px;
              margin: 0 auto;
            }

            .form-signin .form-control {
              position: relative;
              box-sizing: border-box;
              height: auto;
              padding: 10px;
              font-size: 16px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="bootstrap_fixed_header.jsp" />
        <main role="main">
            <section class="jumbotron text-center">
                <div class="container">
                    <form class="form-signin" method="POST">
                        <h1 class="jumbotron-heading">Welcome!</h1>
                        <p class="text-muted">Please sign in</p>
                        <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required autofocus>
                        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
                        <div class="checkbox mb-3">
                            <label>
                                <input type="checkbox" value="remember-me">Remember me
                            </label>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block" type="submit" style="width:100%">Sign in</button><br/>
                        <a href="register.html" class="btn btn-lg btn-secondary btn-block" style="width:100%">Register</a>
                    </form>
                </div>
            </section>
        </main>
        <jsp:include page="bootstrap_fixed_footer.jsp" />
    </body>
</html>