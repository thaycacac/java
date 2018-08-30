<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : ListJob
    Created on : Aug 30, 2018, 10:01:39 AM
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
        <h1>List Job</h1>
        <p>There are ${listJob.size()} jobs</p>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Job Title</th>
                    <th>Company</th>
                    <th>Year of Experience</th>
                    <th>
                        Operations
                    </th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="job" items="${listJob}">
                <tr>
                    <td>${job.id}</td>
                    <td>${job.title}</td>
                    <td>${job.com}</td>
                    <td>${job.exp}</td>
                    <td>
                        <a href="EditJob?id=${job.id}">Edit</a>|<br>
                         <a href="DeleteJob?id=${job.id}">Remove</a>|<br>
                    </td>
                    <td>${job.des}</td>
                </tr>
            </c:forEach>
                
            </tbody>
        </table>
        <a href="ReAddJob">
            <input type="button" value="Add Job" />
        </a>
        <a href="ReListCompany">
            <input type="button" value="List of Company" />
        </a>
    </body>
</html>
