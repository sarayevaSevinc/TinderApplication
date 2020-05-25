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
    <form class="form-signin" method="post"style="background-color: #cc9666;" >
        <img class="mb-4" src="https://tinder.com/static/tinder.png" style="border-radius: 50%;" alt=""  width="100" height="100">
        <h1 class="h3 mb-3 font-weight-normal">Please sign up</h1>
        <label for="inputName" class="sr-only">Full Name</label>
        <input type="text" id="inputName" name="username" class="form-control" placeholder="Full Name" required autofocus>
        <br>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required autofocus>
        <br>
        <label for="inputPosition" class="sr-only">Position</label>
        <input type="text" id="inputPosition" name="position" class="form-control" placeholder="Position" required autofocus>
        <br>
        <label for="gender" class="sr-only">Gender</label>
        <select id="gender" name="gender" name="gender" class="form-control" style="height: 45px;" required autofocus>
            <option value ="none">--Nothing--</option>
            <option value ="male" name="male">Male</option>
            <option value ="female" name="female">Female</option>
            <option value ="other" name="other">Other</option>
        </select>
        <br>

        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        <br>
        <label for="inputUrl" class="sr-only">Position</label>
        <input type="text" id="inputUrl" name="photoUrl" class="form-control" placeholder="PhotoUrl" required autofocus>
        <br>
        ${message!''}
        <button class="btn btn-lg btn-primary btn-block" style="background-color: #bf7b40" type="submit">Sign up</button>
        <a href="/login" style="color: #721c24; " class="mt-5 mb-3"> Have an account? Log in!</a>
        <p class="mt-5 mb-3 text-muted">&copy; Tinder 2020</p>
    </form>

</body>
</html>