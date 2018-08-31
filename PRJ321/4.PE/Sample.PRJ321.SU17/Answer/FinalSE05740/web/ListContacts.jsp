<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : ListContacts
    Created on : Aug 30, 2018, 12:48:19 AM
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
        <h1>List of Contacts</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Group</th>
                    <th>Phone Number</th>
                    <th>Operations</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="con" items="${listCon}">
           <tr>
                    <td>${con.id}</td>
                    <td>${con.fir}</td>
                    <td>${con.las}</td>
                    <td>${con.group}</td>
                    <td>${s.phone}</td>
                    <td>
                        <a href="EditContact?id=${con.id}">Edit</a>
                        <a href="DeleteContact?id=${con.id}">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="ReAddContact">
            <input type="button" value="Add Contact" />
        </a>
        <a href="ReListGroup">
            <input type="button" value="List Group" />
        </a>
    </body>
</html>
