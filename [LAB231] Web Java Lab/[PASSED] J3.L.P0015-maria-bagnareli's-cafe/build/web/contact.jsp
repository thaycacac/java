<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./public/css/style.css" />
        <link rel="stylesheet" type="text/css" href="./public/css/contact-page.css" />
        <title>Contact</title>
    </head>
    <body>
        <div class="wrap-all mb-5">
            <%@include file="/components/header.jsp" %>
            <!--Content-->
            <div class="wrap-content">
                <div class="container flex">
                    <div class="left">
                        <div class="px-3">
                            <p class="pt-5 mt-0 text-6">Find maria's Cafe</p>                   
                            <div class="flex font-sans split-bottom pb-5">
                                <div>
                                    <p class="text-4 font-bold font-serif left-contact">Address and contact:</p>
                                    <p>${contactPhone.key}: ${contactPhone.value}</p>
                                    <p>${contactEmail.key}: ${contactEmail.value}</p>
                                </div>
                                <div>
                                    <p class="text-4 font-bold font-serif">Opening hour:</p>
                                    <ul class="list-reset">
                                        <c:forEach var="work" items="${listWork}">
                                            <li>${work.key}: ${work.value}</li>
                                            </c:forEach>
                                    </ul>
                                </div>
                            </div>
                            <img class="mt-6 image-contact" src="./public/image/9.jpg">
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
