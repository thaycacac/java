<%-- 
    Document   : AddJob
    Created on : Aug 30, 2018, 9:56:51 AM
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
        <h1>Add Job</h1>
        <h5 style="color: red">${error}</h5>
        <form action="AddJob" method="POST">
            <table border="1">
                <tbody>
                     <tr>
                        <td>Job Name</td>
                        <td>
                            <input type="text" name="name" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>Job Company</td>
                        <td>
                            <select name="company">
                                <option value="FSOFT">FPT Software</option>
                                <option value="FU">FPT University</option>
                                <option value="VNPT">VNPT Viet Nam</option>
                                <option value="FHO">FPT</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Year of Experience</td>
                        <td> <input type="text" name="exp" value="" /></td>
                    </tr>
                    <tr>
                        <td>Job Description</td>
                        <td>
                             <input type="text" name="des" value="" />
                        </td>
                    </tr>
                   
                    <tr>
                        <td>
                            <input type="submit" value="Add" />
                        </td>
                        <td>
                            <a href="ReListJob">
                                <input type="button" value="Return to Job List" />
                            </a>
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
