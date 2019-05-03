<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : search
    Created on : Jan 17, 2019, 2:15:18 AM
    Author     : Thaycacac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./public/css/style.css" />
        <link rel="stylesheet" type="text/css" href="./public/css/search-page.css" />
        <title>Search</title>
    </head>
    <body>
        <div>
            <div class="font-sans text-blue">
                <%@include file="/components/header.jsp" %>
                <!--Content-->
                <div class="wrap-content">
                    <div class="flex container">
                        <div class="left pa-5">
                            <c:if test="${result == false}">
                                <p class="not-found">Not found</p>
                            </c:if>
                            <c:forEach var="article" items="${listSearch}">
                                <div>
                                    <p class="text-4 text-blue mt-0 font-bold">
                                        <a class="text-blue" href="viewarticle?id=${article.id}">${article.title}</a>
                                    </p>
                                    <img
                                        alt="title"
                                        src="${article.image}"
                                        class="image-article"/>
                                    <p>${article.description}</p>
                                    <p class="text-gray mt-5 items-end text-right">${mostRecentArticle.author} | ${mostRecentArticle.getDateFormat()}</p>
                                </div>
                            </c:forEach>
                            <div class="flex text-center">
                                <c:forEach var="page" begin="1" end="${numberPage}">
                                    
                                    <c:if test="${pageCurrent == page}">
                                        <p class="page-current mx-2 my-0">${page}</p>
                                    </c:if>
                                    <c:if test="${pageCurrent != page}">
                                        <a href="Search?page=${page}" class="mx-2">${page}</a>
                                    </c:if>

                                </c:forEach>
                            </div>
                        </div>
                        <%@include file="/components/right.jsp" %>
                    </div>
                </div>
                <!--Footer-->
                <footer class="footer">
                </footer>
            </div>
        </div>
    </body>
</html>
