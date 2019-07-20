<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./public/css/style.css" />
        <link rel="stylesheet" type="text/css" href="./public/css/about-page.css" />
        <title>About my Cakes</title>
    </head>
    <body>
        <div class="wrap-all mb-5">
            <%@include file="/components/header.jsp" %>
            <!--Content-->
            <div class="wrap-content">
                <div class="container flex">
                    <div class="left">
                        <div class="px-3 mt-3">
                            <c:forEach var="article" items="${listArticle}">
                                <a class="in-underline" href="About?article=${article.id}">
                                    <p class="text-5 mt-0 mb-2 text-black">${article.title}</p>
                                    <div class="flex">
                                        <img class="mr-3 image-about" src="./public/image/${article.image}">
                                        <p class="mt-0 font-sans text-black">${article.content}</p>
                                    </div>
                                </a>
                            </c:forEach>
                            <div class="flex text-center">
                                <c:forEach var="page" begin="1" end="${numberPage}">

                                    <c:if test="${pageCurrent == page}">
                                        <a href="About?page=${page}" class="page-current mx-2 ">${page}</a>
                                    </c:if>
                                    <c:if test="${pageCurrent != page}">
                                        <a href="About?page=${page}" class="mx-2">${page}</a>
                                    </c:if>

                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <%@include file="/components/right.jsp" %>
                </div>
            </div>
            <hr>
            <!--Footer-->
            <footer class="footer">
                <%@include file="/components/footer.jsp" %>
            </footer>
        </div>
    </body>
</html>
