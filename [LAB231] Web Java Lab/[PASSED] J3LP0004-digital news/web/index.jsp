<%-- 
    Document   : index
    Created on : Jan 15, 2019, 6:46:04 PM
    Author     : Thaycacac
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Digital News</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./public/css/style.css" />
    </head>
    <body>
        <div class="wrap-all">
            <div class="font-sans text-blue">
                <%@include file="/components/header.jsp" %>
                <!--Content-->
                <div class="wrap-content">
                    <div class="container flex">
                        <div class="left pa-5">
                            <p class="text-4 text-blue mt-0 font-bold">${articleCurrent.title}</p>
                            <img
                                alt="title"
                                src="${articleCurrent.image}"
                                class="image-article"/>
                            <p>${articleCurrent.content}</p>
                            <p class="text-gray mt-5 items-end text-right clock">
                                By ${articleCurrent.author} | ${articleCurrent.getDateFormat()}
                            </p>
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