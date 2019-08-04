<%-- 
    Document   : menu
    Created on : May 23, 2018, 11:44:15 AM
    Author     : thuongnnse05095
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Page</title>
        <link type="text/css" rel="stylesheet" href="css/style.css">
    </head>
    <body onload="setGroupMonth()">
        <div id="menu" data-page="Home"></div>
        <div class="wrap">
            <%@include file="header.jsp" %>
            <div class="content">
                <div class="main-content">
                    <div class="content-left">
                        <span>Blog</span>

                        <c:forEach var="element" items="${homes}">
                            <div id="groupMonth" class="header-table" data-date="${element.getCreateDate()}">
                                <h3>${element.getTitleGroup()}</h3>
                                <span class="float-right">Date</span>
                            </div>
                            <div class="menu-container">
                                <div class="title">
                                    <a href="DetailsPost?id=${element.getId()}"><span>${element.getTitle()}</span></a>
                                </div>
                                <div class="like">
                                    <span>${element.getLike()}</span>
                                </div>
                                <div class="comment">
                                    <span>${element.getComment()}</span>
                                </div>
                                <div class="date">
                                    <span>${element.getCreateDate()}</span>
                                </div>
                            </div>
                        </c:forEach>

                        <div class="overview">
                            <a href="OverviewController">Overview</a>
                        </div>

                        <div class="paging">
                            <c:forEach var="j" begin="1" step="1" end="${totalPage}">
                                <c:if test="${page != j}">
                                    <span class="canSelect"><a href="OverviewController?page=${j}" >${j}</a></span> |
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
        <script src="js/overview.js"></script>
    </body>
</html>
