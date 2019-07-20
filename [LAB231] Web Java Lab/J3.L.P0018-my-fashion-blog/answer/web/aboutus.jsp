<%-- 
    Document   : aboutus
    Created on : Jun 13, 2018, 12:30:47 PM
    Author     : thuongnnse05095
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link type="text/css" rel="stylesheet" href="css/style.css">
    </head>
    <body onload="setBold()">
        <div id="menu" data-page="Menu"></div>
        <div class="wrap">
            <%@include file="header.jsp" %>
            <div class="content">
                <div class="main-content">
                    <div class="content-left">
                        <span>About us</span>
                        <div class="aboutus">
                            <img src="${info.getImgLink()}">
                            <span><b>Name: </b>${info.getName()}</span><br><br>
                            <span><b>Age </b>${info.getAge()}</span><br><br>
                            <span>${info.getContent()}</span>
                        </div>
                    </div>
                    <%@include file="container.jsp" %>
                </div>
                <%@include file="footer.jsp" %>
            </div>

        </div>
        <script src="js/menu.js"></script>
    </body>
</html>
