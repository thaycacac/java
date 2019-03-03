<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : ListCompany
    Created on : Aug 30, 2018, 10:10:03 AM
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
        <h1>List Company</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Company Code</th>
                    <th>Company Name</th>
      
                </tr>
            </thead>
            <tbody>
            <c:forEach var="com" items="${listC}">
                <tr>
                    <td>${com.code}</td>
                    <td>${com.name}</td>
         
                </tr>
            </c:forEach>
                
            </tbody>
        </table>
        <a href="ReAddCompany">
            <input type="button" value="Add Company" />
        </a>
        <a href="ReListJob">
            <input type="button" value="List of Job" />
        </a>
    </body>
</html>
