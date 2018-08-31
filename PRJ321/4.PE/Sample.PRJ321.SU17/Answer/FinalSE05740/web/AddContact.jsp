<%-- 
    Document   : AddContact
    Created on : Aug 30, 2018, 12:39:49 AM
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
        <h1>Add a Contact</h1>
        <h5 style="color: red">${error}</h5>
        <form action="AddContact" method="POST">
            <table border="1">

                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td>
                            <input type="text" name="fir" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td>
                            <input type="text" name="las" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>Group</td>
                        <td>
                            <select name="group">
                                <option value="1">Family - Nhom Gia Dinh</option>
                                <option value="2">Personal - Ca Nhan</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Phone Number</td>
                        <td>
                            <input type="text" name="phone" value="" />
                        </td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Add" />
            <a href="ReListContact">
                            <input type="button" value="Return To Contact List" />

            </a>
        </form>
    </body>
</html>
