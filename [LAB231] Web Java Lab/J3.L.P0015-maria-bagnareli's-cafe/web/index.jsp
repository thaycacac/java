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
        <link rel="stylesheet" type="text/css" href="./public/css/home-page.css" />
    </head>
    <body>
        <div class="wrap-all mb-5">
            <%@include file="/components/header.jsp" %>
            <!--Content-->
            <div class="wrap-content">
                <div class="container flex">
                    <div class="left">
                        <div class="px-3">
                            <div class="split-bottom flex pt-5 pb-5">
                                <img class="image-top" src="./public/image/${articleIntroduction.image}">
                                <div class="content">
                                    <p class="text-5 my-0">${articleIntroduction.title}</p>
                                    <p class="font-sans mt-1">${articleIntroduction.content}</p>
                                </div>
                            </div>
                            <div class="split-bottom pt-6 flex pb-5">
                                <div class="mr-3">
                                    <img class="image-bottom" src="./public/image/${articleLeft.image}">
                                    <div class="content">
                                        <p class="text-5 my-0">${articleLeft.title}</p>
                                        <p class="font-sans mt-1">${articleLeft.content}</p>
                                    </div>
                                </div>
                                <div>
                                    <img class="image-bottom" src="./public/image/${articleRight.image}">
                                    <div class="content">
                                        <p class="text-5 my-0">${articleRight.title}</p>
                                        <p class="font-sans mt-1">${articleRight.content}</p>
                                    </div>
                                </div>
                            </div>
                            <div class="split-bottom pb-5">
                                <p class="text-5">Visit my cafe</p>
                                <p>${contactAddress.value}</p>
                                <p>${contactPhone.key}: ${contactPhone.value}</p>
                            </div>
                            <div class="mt-6">
                                <p>Kind regards</p>
                                <p class="text-5">Visit my cafe</p>
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