<%-- 
    Document   : Register
    Created on : Aug 16, 2018, 2:08:30 PM
    Author     : Thaycacac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <style>
            body {
                background-color: aqua;
            }
        </style>
        <link href="myStyle.css" rel="stylesheet">
    </head>
    <body>
        <div class="containerRegister">
            <h1>Register</h1>
            <form action="AddUser" method="POST" class="myForm">
                Username:
                <br>
                <input type="text" name="username" class="myInput">
                <br> First Name:
                <br>
                <input type="text" name="firstname" class="myInput">
                <br> Last Name:
                <br>
                <input type="text" name="lastname" class="myInput">
                <br> Password:
                <br>
                <input type="password" name="password" class="myInput">
                <br> Confirm Password:
                <br>
                <input type="password" name="confirmPassword" class="myInput">
                <br> Email:
                <br>
                <input type="email" name="email" class="myInput">
                <br> Gender:
                <br>
                <input type="radio" name="gender" value="male"> Male
                <input type="radio" name="gender" value="female"> Female
                <br>
                <input type="checkbox" name="check" value="check">I accept Terms and Conditions<br>
                <br>
                <br>
                <input type="submit" value="Register" class="myButton">
            </form>
        </div>
    </body>
</html>
