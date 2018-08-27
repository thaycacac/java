<%-- 
    Document   : loginname
    Created on : Aug 23, 2018, 2:38:39 PM
    Author     : Thaycacac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../myStyle.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <title>Login Name</title>
    </head>
    <body>
        <div class="container">
            <div class="container-login">
                <h3>Enter your name</h3>
                <form action="StudentEnterName" method="POST">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Enter your name" name="name">
                    </div>
                    <button type="submit" class="btn btn-primary">Join</button>
                </form>
            </div>
        </div>
    </body>
</html>
