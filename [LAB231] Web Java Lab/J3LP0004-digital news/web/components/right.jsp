<%-- 
    Document   : right
    Created on : Jan 17, 2019, 10:44:54 AM
    Author     : Thaycacac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="right py-5 pl-3 pr-5">
            <!--The most recent news-->
            <div>
                <p class="text-4 font-bold mt-0 text-blue">Digital News</p>
                <p>${mostRecentArticle.description}</p>
            </div>
            <!--Search news by new title-->
            <div>
                <p class="text-4 font-bold">Search</p>
                <form class="flex" method="POST" action="Search">
                    <input type="text" class="border-dotted search" name="keyword">
                    <input type="submit" class="text-blue border-none bg-none" value="Go">
                </form>
            </div>
            <!--Top 5 most recent news-->
            <div>
                <p class="text-4 font-bold">Last Articles</p>
                <ul class="list-reset">
                    <c:forEach var="article" items="${fiveRecentAticle}">
                        <li class="mt-5"><a href="viewarticle?id=${article.id}" class="text-blue underline">${article.title}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </body>
</html>
