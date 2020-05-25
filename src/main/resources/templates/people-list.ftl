<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">


    <title>People list</title>
    <#include "css/bootstrap.min.css">

    <#include "css/style.css">

</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-8 offset-2">
            <div class="mt-4">
                <div class="d-flex justify-content-center links">
                    <form  method="post" >
                        <button type="submit"  name="button" value="logout">Logout </button>
                    </form>
                </div>
            </div>
            <div class="panel panel-default user_panel">
                <div class="panel-heading">
                    <h3 class="panel-title">User List</h3>
                </div>

                <div class="panel-body">
                    <div class="table-container">
                        <table class="table-users table" border="0">
                            <tbody>
                            <#list allusers as user>
                                <tr>
                                    <td width="10">
                                        <div class="avatar-img">
                                            <img class="img-circle"
                                                 src=${user.getUrlPhoto()}/>  
                                        </div>

                                    </td>
                                    <td class="align-middle">
                                        ${user.getFullName()}
                                    </td>
                                    <td class="align-middle">
                                        ${user.getPosition()}
                                    </td>
                                    <td class="align-middle">
                                        <form  method="post" >
                                            <input type="hidden"  name="id" value="${user.getId()}" >
                                            <button type="submit"  name="button" value="message">Message</button>
                                        </form>
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
