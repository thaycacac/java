<%-- 
    Document   : practiceJSTL
    Created on : Aug 20, 2018, 2:30:29 PM
    Author     : Thaycacac
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Practice JSTL</title>
    </head>
    <body>
        <!--CORE-->
        <c:set var="student1" value="HoaPN"></c:set>
        <c:out value="${student1}">No name</c:out> <br>
        <c:remove var="student1"/>
        <c:out value="${student1}">No name</c:out><br>

        <c:if test="${student2 == null}">Student2 is Null</c:if><br>

        <c:set var="student2" value="CuongNX"></c:set>
        <c:choose>
            <c:when test="${student2 == null}">Student2 is Null</c:when>
            <c:when test="${student2 == 'CuongNX'}">Student2 is CuongNX</c:when>
            <c:otherwise>Default</c:otherwise>
        </c:choose><br>
        <%--<c:redirect url = "/HelloCustomTadWorld.jsp"/>--%>

        <!--I18N-->
        <c:set var="money" value="123456789.321"></c:set>
        <fmt:formatNumber value="${money}" type="currency"></fmt:formatNumber><br>
        <fmt:setLocale value="vi_VN"/>
        <fmt:formatNumber value="${money}" type="currency"></fmt:formatNumber><br>

        <c:set var="today" value="<%= new java.util.Date()%>"></c:set>
        <fmt:formatDate type="date" value="${today}"></fmt:formatDate><br>

            <!--SQL-->
        <sql:setDataSource 
            var="db" 
            driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
            url="jdbc:sqlserver://localhost:1433; databaseName=PRJ321; user = sa; password = 123456"
            user="sa"
            password="123456"></sql:setDataSource>
        <sql:query var="result" dataSource="${db}" sql="SELECT * FROM dbo.Student">
        </sql:query>
        <c:forEach items="${result.rows}" var="student">
            <c:out value="${student.name}"></c:out><br>
        </c:forEach>

        <!--XML-->
        <c:import var="lib" url="test.xml"></c:import>
        <x:parse var="doc" xml="${lib}"/>
        <table border="1">
            <tr>
                <td>Title</td><td>Author</td><td>Page</td>
            </tr>
            <x:forEach var="ob" select="$doc/root/book">
                <tr>
                    <td><x:out select="$ob/title"/></td>
                    <td><x:out select="$ob/author"/></td>
                    <td><x:out select="$ob/page"/></td>
                </tr>
            </x:forEach>
        </table>
    </body>
</html>
