<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : ListGroups
    Created on : Aug 30, 2018, 12:52:24 AM
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
        <h1>List Of Group</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Group Name</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="group" items="${listGr}">
                <tr>
                    <td>${group.id}</td>
                    <td>${group.name}</td>
                    <td>${group.des}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="ReAddGroup">
            <input type="button" value="Add Group" />
        </a>
        <a href="ReListContact">
            <input type="button" value="List Contact" />
        </a>
    </body>
</html>
