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

    <title>Like page</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body  style="background-color: #d9b08c" >

<div class="col-4 offset-4">
    <div class="card">
        <div class="card-body">
            <div class="row">

                <div class="col-12 col-lg-12 col-md-12 text-center">
                    <img  src="${urlPhoto}" alt=""  width="100" height="100"  class="mx-auto rounded-circle img-fluid">
                    <h3 class="mb-0 text-truncated">${name}</h3>
                    <h4 class="mb-0 text-truncated"> ${position} </h4>
                    <br>
                </div>
                <div class="col-12 col-lg-6">
                    <form  method="post" >
                        <input type="hidden"  name="id" value="${id}" >
                    <button type="submit"  value="dislike" name="button" class="btn btn-outline-danger btn-block"><span class="fa fa-times"></span> Dislike</button>
                    </form>
                </div>
                <div class="col-12 col-lg-6">
                   <form  method="post" >
                        <input type="hidden"  name="id" value="${id}" >
                    <button type="submit"  value="like" name="button" class="btn btn-outline-success btn-block"> <span class="fa fa-heart"></span> Like</button>
                    </form>
                </div>

                <div class="col-12 col-lg-6">
                    <form  method="post" >
                        <button type="submit"  value="LikedList" name="button" class="btn btn-outline-danger btn-block"><span class="fa fa-times"></span> LikedList</button>
                    </form>
                </div>
                <div class="col-12 col-lg-6">
                    <form  method="post" >
                        <button type="submit"  value="Logout" name="button" class="btn btn-outline-success btn-block"> <span class="fa fa-heart"></span> Logout</button>
                    </form>
                </div>
                <!--/col-->
            </div>
            <!--/row-->
        </div>
        <!--/card-block-->

    </div>
</div>

</body>
</html>