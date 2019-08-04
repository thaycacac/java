<%-- 
    Document   : detailsPost
    Created on : Jun 1, 2018, 11:50:54 AM
    Author     : thuongnnse05095
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link type="text/css" rel="stylesheet" href="css/style.css">
        <link href="css/detail.css" rel="stylesheet" type="text/css"/>
        <link href="css/container.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrap">
            <%@include file="header.jsp" %>
            <div class="content">
                <div class="main-content">
                    <div class="content-left">
                        <div class="details">
                            <span>${content.getTitle()}</span>
                            <div class="post">
                                <div class="left-post">
                                    <img src="${content.getImgLink()}" alt="">
                                </div>
                                <div class="right-post">
                                    <p>${content.getFullContent()}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%@include file="container.jsp" %>
                </div>
                <%@include file="footer.jsp" %>
            </div>

        </div>
    </body>
</html>
