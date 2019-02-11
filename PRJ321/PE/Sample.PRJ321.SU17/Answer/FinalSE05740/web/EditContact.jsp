<%-- 
    Document   : Edit
    Created on : Aug 30, 2018, 12:43:43 AM
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
        <h1>Edit a Contact</h1>
        <h5 style="color: red">${error}</h5>
        <form action="EditContact" method="POST">
            <table border="1">

                <tbody>
                    <tr>
                        <td>ID</td>
                        <td>
                            <input type="text" name="id" value="${stu.id}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>First Name</td>
                        <td>
                            <input type="text" name="fir" value="${stu.fir}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td>
                            <input type="text" name="las" value="${stu.las}" />
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
                            <input type="text" name="phone" value="${stu.phone}" />
                        </td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Edit" />
            <a href="ReListContact">
                            <input type="button" value="Return To Contact List" />

            </a>
        </form>
    </body>
</html>
