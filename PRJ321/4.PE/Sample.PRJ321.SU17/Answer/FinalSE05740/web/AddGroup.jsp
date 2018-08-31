<%-- 
    Document   : AddGroup
    Created on : Aug 30, 2018, 12:45:59 AM
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
        <h1>Add a Group</h1>
        <form action="AddGroup" method="POST">
            <table border="0">

                <tbody>
                    <tr>
                        <td>Name:</td>
                        <td>
                            <input type="text" name="name" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>
                            <input type="text" name="des" value="" />
                        </td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Add" />
            <a href="ReGroupList">
                <input type="button" value="Return To Group List" />
            </a>
        </form>
        
    </body>
</html>
