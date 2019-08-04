<%-- 
    Document   : registerForm
    Created on : May 16, 2018, 11:33:22 AM
    Author     : minhndse04560
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String messageClass = (String) request.getAttribute("messageClass");
    String message = (String) request.getAttribute("message");
    String userName = "";
    int type = 0;
    String email = "";
    if (message != null) {
        userName = (String) request.getAttribute("savedUserName");
        email = (String) request.getAttribute("savedEmail");
        type = Integer.parseInt(request.getAttribute("savedType").toString());
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
        <h4 class="loginFornTitle">Registration form</h4>
        <% if ((message != null)&&(!message.equals(""))) { %>
        <span class="<%=messageClass %>"><%=message%></span>
        <% } %>
        <form action="#" method="post">
            <input type="hidden" name="request" value="register">
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
                        <td>Type</td>
                        <td>
                            <select name='type' value="<%=type%>">
                                <option value='0' <%=(type == 0) ? "selected" : "" %>>Student</option>
                                <option value='1' <%=(type == 1) ? "selected" : "" %>>Teacher</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Email: </td>
                        <td><input type="email" value="<%=email %>" name='email'></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Register"></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
