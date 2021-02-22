<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!doctype html>
<html>
    <head>
        <jsp:include page="standard_html_header.jsp" />
        <link href="fixed_header.css" rel="stylesheet">
        <link href="fixed_footer.css" rel="stylesheet">
        <link href="standard.css" rel="stylesheet">
        <title>Register with snack vendor</title>

        <script>
            function activateAlert(field, message) {
                var emailAlertEle = document.getElementById("alert"+field);
                emailAlertEle.innerHTML = '<div class="alert alert-warning alert-dismissable fade show" role="alert" style="width:100%"><strong>Attention!</strong>'+message+'<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>';
            }

            function ensureMatch(field) {
                var baseEle = document.getElementById("input"+field);
                var confirmEle = document.getElementById("confirm"+field);
                var isMatch = baseEle.value == confirmEle.value;
                var fieldName = field.toLowerCase();
                if (baseEle.value.length == 0 || confirmEle.value.length == 0) {
                    activateAlert(field, "Neither "+fieldName+" field may be blank.");
                } else if (!isMatch) {
                    activateAlert(field, "Your "+fieldName+" fields did not match.");
                }
                alert("Match? "+isMatch+" ("+baseEle.className+")");
                return isMatch;
            }

            function validateForm() {
                var emailMatch = ensureMatch("Email");
                var passwordMatch = ensureMatch("Password");
                return emailMatch && passwordMatch;
            }
        </script>
    </head>
    <body>
        <jsp:include page="bootstrap_fixed_header.jsp" />
        <main role="main">
            <section class="container text-center">
                <form class="form" method="POST" onsubmit="return validateForm()">
                    <h1 class="h3 mb-3 font-weight-normal">Registration:</h1>
                    <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                    <input type="email" id="confirmEmail" name="confirmEmail" class="form-control" placeholder="Confirm email" required>
                    <div class="row" id="alertEmail"></div>
                    <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Password" required>
                    <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" placeholder="Confirm Password" required>
                    <div class="row" id="alertPassword"></div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" style="width:100%">Register</button><br/>
                </form>
            </section>
        </main>
        <jsp:include page="bootstrap_fixed_footer.jsp" />
    </body>
</html>