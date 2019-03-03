<%-- 
    Document   : AddGroup
    Created on : Aug 30, 2018, 10:07:57 AM
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
        <h1>Add Conpany</h1>
        <form action="AddCompany" method="POST">
            <table border="1">
                <tbody>
                     <tr>
                        <td>Company Code:</td>
                        <td>
                            <input type="text" name="code" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>Company Name:</td>
                        <td>
                             <input type="text" name="name" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Add" />
                        </td>
                        <td>
                            <a href="ReListCompany">
                                <input type="button" value="Return to Company List" />
                            </a>
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
