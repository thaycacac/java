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
    <body onload="setBold()">
        <div id="menu" data-page="Home"></div>
        <div class="wrap">
            <%@include file="header.jsp" %>
            <div class="content">
                <div class="main-content">
                    <div class="content-left">
                        <div class="post">
                            <div class="icon-post-${content.getType()}"></div>
                            <div class="content-post">
                                <div class="title-post">
                                    <a class="title-details">${content.getTitle()}</a>
                                    <span>${content.getCreateDate()}</span>
                                </div>
                                <div class="${content.getType()}">
                                    <a><img src="${content.getImgLink()}"></a>
                                        <c:choose>
                                            <c:when test="${content.getType()=='note'}">
                                            <blockquote class="content-s">
                                                <p>${content.getContent()}</p>
                                                <small>${content.getAuthor()}</small>
                                            </blockquote>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="content-s">
                                                ${content.getContent()}
                                            </span>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="border-post"></div>
                            </div>
                        </div>                        <div class="overview-details">
                            <a href="OverviewController">Overview</a>
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
