<%-- 
    Document   : Login
    Created on : Aug 16, 2018, 2:10:01 PM
    Author     : Thaycacac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            body {
                background-color: aqua;
            }
        </style>
        <link href="myStyle.css" rel="stylesheet">
    </head>
    <body>
        <div class="containerLogin">
            <h1>Login</h1>
            <form action="AuthenticationServlet" method="POST" class="myForm">
                Username:
                <br>
                <input type="text" name="username" class="myInput">
                <br> Password:
                <br>
                <input type="password" name="password" class="myInput" value="${authorizedUser.password}">
                <br>
                <input type="checkbox" name="check" value="check">Remember my Password<br>
                <br>
                <br>
                <input type="submit" value="Login" class="myButton">
            </form>
        </div>
    </body>
</html>
