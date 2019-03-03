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
            <p> Hello user (<%= fullName%>)</p>
            <br>
            <%!
                String username, fullName;
            %>
            <%
                username = request.getAttribute("username").toString();
                fullName = request.getAttribute("fullname").toString();
            %>
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
            <%
                StudentDAO dao = new StudentDAO();
                ArrayList<Student> listStudent = dao.getAllStudent();
                for (Student student : listStudent) {
                    if (student.getTaker().equalsIgnoreCase(username)) {
            %>
            <div class="myTable">
                <div class="myItem myNo"><%= student.getNo()%></div>
                <div class="myItem">
                    <a href="#"><%= student.getGroup()%></a>
                </div>
                <div class="myItem myCode"><%= student.getCode()%></div>
                <div class="myItem">
                    <a href="#"><%= student.getName()%></a>
                </div>
                <div class="myItem">
                    <img src="<%= student.getImage()%>" alt="">
                </div>
                <div class="myItem <%= student.getStatus()%>"><%= student.getStatus()%></div>
                <div class="myItem"></div>
                <div class="myItem myCode"><%= student.getTaker()%></div>
                <div class="myItem"><%= student.getTime()%></div>
            </div>
            <%
                    }
                }
            %>
        </div>
    </body>
</html>
