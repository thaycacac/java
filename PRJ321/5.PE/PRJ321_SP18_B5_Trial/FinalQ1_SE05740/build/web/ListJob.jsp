<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Job Management</title>
    </head>
    <body>
        <h1>Job Management</h1>
        <form action="ListCompanyServlet" method="POST">
            <p>There are ${listJob.size()} jobs</p>
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Job Title</th>
                        <th>Company</th>
                        <th>Year of Experience</th>
                        <th>Operations</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="job" items="${listJob}">
                        <tr>
                            <td>${job.id}</td>
                            <td>${job.title}</td>
                            <td>${job.companyCode}</td>
                            <td>${job.exp}</td>
                            <td>
                                <a href="/FinalQ1_SE05740/edit/edit?id=${job.id}">Edit</a>|
                                <a href="/FinalQ1_SE05740/delete/dele?id=${job.id}">Remove</a>
                            </td>
                            <td>${job.des}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <input type="submit" value="Add Job" formaction="AddJobServlet" formmethod="GET"/>
            <input type="submit" value="List of Company"/>
        </form>
    </body>
</html>
