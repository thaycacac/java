<%-- 
    Document   : login.jsp
    Created on : Aug 21, 2018, 2:56:07 PM
    Author     : Thaycacac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="LoginServlet" method="POST">
        <p>User</p><input type="text" name="username">
        <p>PassWord</p><input type="password" name="password">
        <input type="submit" value="login">
        </form>
    </body>
</html>
