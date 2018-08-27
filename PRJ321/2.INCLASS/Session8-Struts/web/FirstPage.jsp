<%-- 
    Document   : FirstPage.jsp
    Created on : Aug 22, 2018, 2:18:40 PM
    Author     : duongtb
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>First Page</title>
    </head>
    <body>
        <h1>Input your information please!</h1>
        <form action="hello" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="firstName"/></td>
                        <td><s:fielderror fieldName="firstName"/></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lastName"/></td>
                        <td><s:fielderror fieldName="lastName"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit"/></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
