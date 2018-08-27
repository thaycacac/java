<%-- 
    Document   : ListAllStudent
    Created on : Aug 15, 2018, 2:27:39 PM
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List Student</h1>
        <table border="1">
        <%
            StudentDAO dao = new StudentDAO();
            ArrayList<Student> listStudent = dao.getAllStudent();
            for (Student student : listStudent) {
        %>
        
            <tr>
                <td><%= student.getId()%></td>
                <td><%= student.getName()%></td>
                <td><%= student.getDob()%></td>
                <td><%= student.getImage()%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
<!--response.sendRedirect("ShowAllStudent.jsp")
request.getRequestDispatcher("ShowAllStudent.jsp").foward()-->