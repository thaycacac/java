<%-- 
    Document   : index
    Created on : May 16, 2018, 10:57:43 AM
    Author     : minhndse04560
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String includePage = (String) request.getAttribute("page");
    String user = (String) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="resource/css/index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Easy CMS</title>
    </head>
    <body>
        <div id="main-panel">
            <div id="nav-bar">
                <ul>
                    <li><a href='Index'>Home</a></li>
                    <li><a href='TakeQuiz'>Take Quiz</a></li>
                    <li><a href='MakeQuiz'>Make Quiz</a></li>
                    <li><a href='ManageQuiz'>Manage Quiz</a></li>
                        <% if (user != null) { %>
                    <li><a href='Logout'>Logout</a></li>
                        <% }%>
                </ul>
            </div>
            <div id="main-content">
                <jsp:include page="<%= includePage%>" />
            </div>
        </div>
    </body>
</html>
