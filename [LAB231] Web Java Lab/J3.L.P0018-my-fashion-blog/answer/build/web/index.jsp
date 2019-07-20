<%-- 
    Document   : home
    Created on : May 18, 2018, 11:02:36 AM
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
                        <span>Blog</span>

                        <c:forEach var="post" items="${homes}">
                            <div class="post">
                                <div class="icon-post-${post.getType()}"></div>
                                <div class="content-post">
                                    <div class="title-post">
                                        <a href="DetailsPost?id=${post.getId()}">${post.getTitle()}</a>
                                        <span>${post.getCreateDate()}</span>
                                    </div>
                                    <div class="${post.getType()}">
                                        <a href="DetailsPost?id=${post.getId()}"><img src="${post.getImgLink()}"></a>
                                        <span class="content-s">${post.getContent()}</span>
                                    </div>
                                </div>
                            </div>
                            <div class="border-post"></div>
                        </c:forEach>

                        <div class="overview">
                            <a href="OverviewController">Overview</a>
                        </div>

                        <div class="paging">
                            <c:forEach var="j" begin="1" step="1" end="${totalPage}">
                                <c:if test="${page != j}">
                                    <span class="canSelect"><a href="HomeController?page=${j}" >${j}</a></span> |
                                    </c:if>
                                    <c:if test="${page == j}">
                                    <span class="notSelect">${j}</span> |
                                </c:if>
                            </c:forEach>
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
