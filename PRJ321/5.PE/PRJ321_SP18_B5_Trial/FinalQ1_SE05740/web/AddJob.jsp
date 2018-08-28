<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Job</title>
    </head>
    <body>
        <h1>Add Job</h1>
        <form action="AddJobServlet" method="POST">
            <table border="1">
                <tr>
                    <td>Job Name</td>
                    <td>
                        <input type="text" name="name" />
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
                    <td>
                        <input type="text" name="exp"/>
                    </td>
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
                        <input type="submit" value="Return to Job List" formaction="ListJobServlet" formmethod="POST"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
