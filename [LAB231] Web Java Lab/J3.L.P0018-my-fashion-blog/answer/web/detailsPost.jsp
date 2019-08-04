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
    </head>
    <body>
        <div class="wrap">
            <%@include file="header.jsp"%>
            <div class="content">
                <div class="main-content">
                    <div class="content-left">
                        <div class="post">
                            <div class="icon-post-${content.getType()}"></div>
                                <div class="content-post">
                                    <div class="title-post">
                                        <a href="DetailsPost?id=${content.getId()}">${content.getTitle()}</a>
                                        <span>${content.getCreateDate()}</span>
                                    </div>
                                    <div class="pen">
                                        <img src="${content.getImgLink()}">
                                        <span>${content.getContent()}</span>
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
