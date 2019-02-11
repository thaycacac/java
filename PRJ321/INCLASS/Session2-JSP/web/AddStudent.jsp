<%-- 
    Document   : AddStudent
    Created on : Aug 15, 2018, 5:37:34 PM
    Author     : Thaycacac
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dataobj.Student"%>
<%@page import="dataobj.Student"%>
<%@page import="dal.StudentDAO"%>
<%@page import="dal.StudentDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>
    </head>
    <body>
        <%!
            int no;
        %>
        <%
            StudentDAO dao = new StudentDAO();
            ArrayList<Student> listStudent = dao.getAllStudent();
            no = listStudent.size() + 1;
        %>
        <h1>Add Student</h1>
        <form action="AddStudentServlet" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th><%=no%></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Group</td>
                        <td><input type="text" name="group" value="PRJ321.EB5"></td>
                    </tr>
                    <tr>
                        <td>Code</td>
                        <td><input type="text" name="code"></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>Image</td>
                        <td><input type="file" name="image"></td>
                    </tr>
                    <tr>
                        <td>Status</td>
                        <td><input type="radio" name="status" value="absent"> Absent<br>
                            <input type="radio" name="status" value="present"> Present<br></td>
                    </tr>
                    <tr>
                        <td>Comment</td>
                        <td><input type="text" name="comment"></td>
                    </tr>
                    <tr>
                        <td>Taker</td>
                        <td><input type="text" name="taker"></td>
                    </tr>
                    <tr>
                        <td>Record time</td>
                        <td><input type="date" name="time"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Add"></td>
                    </tr>
                </tbody>
            </table>
        </form>

    </body>
</html>
