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
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>
        <link href="css/container.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>     
        <div class="wrap">
            <%@include file="header.jsp" %>
            <div class="content">
                <div class="main-content">
                    <div class="content-left">
                        <h2>Menu and Price list</h2>
                        <c:if test="${not empty noContent}">
                            <h3>${noContent}</h3>
                        </c:if>
                        <c:if test="${empty noContent}">    
                            <c:forEach var="i" items="${menus}">
                                <div class="menu-container">
                                    <div class="order">
                                        <span>Menu ${i.getId()}</span>
                                        <span class="float-right">Price</span>
                                    </div>
                                    <div class="title">
                                        <span>${i.getName()}</span>
                                        <span class="float-right">$${i.getPrice()}</span>
                                    </div>
                                    <div class="descriptment">
                                        <span>${i.getContent()}</span>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                        <div class="paging">
                            <c:forEach var="j" begin="1" step="1" end="${totalPage}">
                                <c:if test="${page != j}">
                                    <a href="MenuController?page=${j}" >${j}</a> |
                                </c:if>
                                <c:if test="${page == j}">
                                    ${j} |
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                    <%@include file="container.jsp" %>
                </div>
                <%@include file="footer.jsp" %>
            </div>
        </div>
    </body>
</html>
