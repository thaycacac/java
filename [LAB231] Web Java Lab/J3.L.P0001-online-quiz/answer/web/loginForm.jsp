<%-- 
    Document   : loginForm
    Created on : May 16, 2018, 11:24:17 AM
    Author     : minhndse04560
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String message = (String) request.getAttribute("m");
    String userName = "";
    if (message != null) {
        userName = (String) request.getAttribute("savedUserName");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resource/css/common.css">
        <link rel="stylesheet" href="resource/css/loginForm.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h4 id="loginFornTitle">Login Form</h4>
        <% if ((message != null) && (message.equals("fail"))) { %>
        <span class="failed">Username or password is incorrect, please try again</span>
        <% } %> 
        <form action="Login" method="post">
            <table>
                <tbody>
                    <tr>
                        <td>User Name: </td>
                        <td><input type="text" value="<%=userName %>" name="username"></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Sign In">
                            <a href="Register">Register</a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
