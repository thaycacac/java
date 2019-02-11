<%-- 
    Document   : index
    Created on : Aug 14, 2018, 1:28:10 PM
    Author     : Thaycacac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! This is the JSP wellcome file</h1>
        <% out.println("My name is: " + name + ", age: " + age + "year old.");
        %>
        <%!
            String name = "abcd";
            int age = 20;
            String data = "";
            void processData(){
                data = name + "with" + age + "years old";
            }
        %>
        <%
            out.println("Welcome to JSP world");
            out.print("the data before is: " + data);
            processData();
            out.print("the data after is: " + data);
        %>
        The author of this page is <%= name %>
        <%--<%@include file="header.jsp" %>--%>
        <% request.setAttribute("hello", name); %>
        ========================
        <%@include file="header.jsp" %>
        ========================
        <jsp:include page="header.jsp"></jsp:include>
        <!--out.print(name)-->
    </body>
</html>
