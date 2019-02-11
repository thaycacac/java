<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : ShowAllStudent
    Created on : Aug 15, 2018, 5:24:39 PM
    Author     : Thaycacac
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dataobj.Student"%>
<%@page import="dal.StudentDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Result</title>
        <link href="myStyle.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <p class="myTitle">Single activity Attendance</p>
            <p> Hello user ${fullname}</p>
            <br>
            <a href="#" class="myCode">Edit this Attendance</a>
            <p>Attendance for
                <span class="mySpan">PRJ321</span> with leacturer
                <span class="mySpan">Duong TB</span>
                at slot 4 on Monday 13/08/2018, in room HB/305L at FU-HL</p>
            <div class="myTableField">
                <div class="myItemField">No</div>
                <div class="myItemField">Group</div>
                <div class="myItemField">Code</div>
                <div class="myItemField">Name</div>
                <div class="myItemField">Image</div>
                <div class="myItemField">Status</div>
                <div class="myItemField">Comment</div>
                <div class="myItemField">Taker</div>
                <div class="myItemField">Record Time</div>
            </div>

            <c:forEach var="thestudent" items="${listStudent}">
                <div class="myTable">
                    <div class="myItem myNo">${thestudent.name}</div>
                    <div class="myItem">
                        <a href="#">${thestudent.group}</a>
                    </div>
                    <div class="myItem myCode">${thestudent.code}</div>
                    <div class="myItem">
                        <a href="#">${thestudent.name}</a>
                    </div>
                    <div class="myItem">
                        <img src="${thestudent.image}" alt="">
                    </div>
                    <div class="myItem ${thestudent.status}">${thestudent.status}</div>
                    <div class="myItem"></div>
                    <div class="myItem myCode">${thestudent.taker}</div>
                    <div class="myItem">${thestudent.time}</div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
