<html>
    <head>
        <jsp:include page="standard_html_header.jsp" />
        <link href="fixed_header.css" rel="stylesheet">
        <link href="fixed_footer.css" rel="stylesheet">
        <link href="standard.css" rel="stylesheet">
        <title>Game selector</title>
    </head>
    <body>
        <jsp:include page="bootstrap_fixed_named_header.jsp" />
                <main role="main">
                    <section class="container text-center">
                        <form class="form" method="POST" action="sign_in.html">
                            <h1 class="h3 mb-3 font-weight-normal">Welcome!</h1>
                            <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" style="width:100%" required autofocus>
                            <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
                            <div class="checkbox mb-3">
                                <label>
                                    <input type="checkbox" value="remember-me">Remember me
                                </label>
                            </div>
                            <button class="btn btn-lg btn-primary btn-block" type="submit" style="width:100%">Sign in</button><br/>
                            <a href="register.html" class="btn btn-lg btn-secondary btn-block" style="width:100%">Register</a>
                        </form>
                    </section>
                </main>
                <jsp:include page="bootstrap_fixed_footer.jsp" />
    </body>
</html>