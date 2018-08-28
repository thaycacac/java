<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Management</title>
    </head>
    <body>
        <h1>Company Management</h1>
        <form action="ListJobServlet" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>Company Code</th>
                        <th>Company Name</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="com" items="${listCom}">
                        <tr>
                            <td>${com.code}</td>
                            <td>${com.name}</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
            <input type="submit" value="List of Job">
            <input type="submit" value="Add Company" formaction="AddCompanyServlet" formmethod="GET"/>
        </form>
    </body>
</html>
