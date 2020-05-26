<#include "css/style.css">
<#include "css/bootstrap.min.css">
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/favicon.ico">

    <title>Signin Template for Bootstrap</title>


</head>

<body class="text-center" style="background-color: #d9b08c" >
    <form class="form-signin" method="post" style="background-color: #cc9666">
        <img class="mb-4" src="https://tinder.com/static/tinder.png" style="border-radius: 50%;" alt=""  width="100" height="100">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name="email" class="form-control" style="background-color:#e6cab3" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword"  name="password" style="background-color: #e6cab3" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="background-color: #bf7b40">Sign in</button>
        <a href="/register" style="color: #86552d; " class="mt-5 mb-3"> Don't have an account? Register!</a>
        <p class="mt-5 mb-3 text-muted">&copy; Tinder 2020</p>
    </form>
</body>
</html>