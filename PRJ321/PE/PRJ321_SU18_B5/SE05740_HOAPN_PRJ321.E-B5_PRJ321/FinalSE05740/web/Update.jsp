<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Update
    Created on : Aug 30, 2018, 2:04:27 PM
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
        <h1>Well come ${name}</h1>
        <table >
            <tbody>
                <tr>
                    <td>
                        <a href="ReHome">Home</a>
                    </td>
                    <td><a href="ReSub">Subject</a></td>
                    <td><a href="ReUpdate">Update Subject</a></td>
                </tr>
            </tbody>
        </table>

        <form action="SearchSe" method="POST">
            <p>Select a Semester</p>
            <select name="sem">
                <option value="0">All</option>
                <option value="1">Spring2017</option>
                <option value="2">Spring2016</option>
                <option value="3">Summer2017</option>
            </select>
            <input type="submit" value="Search" />
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>Subject ID</th>
                    <th>Semester ID</th>
                    <th>Subject Name</th>
                    <th>Credit</th>
                    <th>Last update</th>
                    <th>Is Active</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="subj" items="${listSub}">
               <tr>
                    <td>${subj.suid}</td>
                    <td>${subj.seid}</td>
                    <td>${subj.sub}</td>
                    <td>${subj.cre}</td>
                    <td>${subj.date}</td>
                    
                    <td>
                <input type="checkbox" name="active" <c:if test="${subj.active == true}">checked </c:if>/>
                </td>
                <td>
                    <a href="UpdateSu?id=${subj.suid}">Update</a>
                </td>
                
                </tr>
            </c:forEach>
          

        </tbody>
    </table>
    <p>This list has ${listSub.size()}</p>

</body>
</html>
