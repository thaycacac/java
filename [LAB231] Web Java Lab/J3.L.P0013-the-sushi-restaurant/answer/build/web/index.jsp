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
        <link href="css/container.css" rel="stylesheet" type="text/css"/>
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrap">
            <%@include file="header.jsp" %>
            <div class="content">
                <div class="main-content">
                    
                    <div class="content-left">
                        <div class="img-border">
                            <img src="${urlCover}" alt="">
                        </div>
                        <c:if test="${not empty noContent}">
                            <h3>${noContent}</h3>
                        </c:if>
                        <c:if test="${empty noContent}">   
                            <c:forEach var="i" items="${content}">
                                <div class="border-post">
                                    <span><a href="DetailsPost?id=${i.getId()}">${i.getTitle()}</a></span>
                                    <div class="post">
                                        <div class="left-post">
                                            <a href="DetailsPost?id=${i.getId()}"><img src="${i.getImgLink()}" alt=""></a>
                                        </div>
                                        <div class="right-post">
                                            <p>${i.getContent()}</p>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                        <div class="paging">
                            <c:forEach var="j" begin="1" step="1" end="${totalPage}">
                                <c:if test="${page != j}">
                                    <a href="HomeController?page=${j}" >${j}</a> |
                                </c:if>
                                <c:if test="${page == j}">
                                    ${j} |
                                </c:if>
                            </c:forEach>.
                        </div>
                    </div>
                    <%@include file="container.jsp" %>
                </div>
                <%@include file="footer.jsp" %>
            </div>
        </div>
    </body>
</html>
