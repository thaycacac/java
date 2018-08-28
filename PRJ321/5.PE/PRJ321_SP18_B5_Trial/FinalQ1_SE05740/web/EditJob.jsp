<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Job</title>
    </head>
    <body>
        <h1>Edit Job</h1>
        <form action="" method="POST">
            <table border="1">
                <tr>
                    <td>Job Name</td>
                    <td>
                        <input type="text" name="title" value="${edit.title}"/>
                    </td>
                </tr>
                <tr>
                    <td>Job Company</td>
                    <td>
                        <select name="company">
                            <option>${edit.companyCode}</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Year of Experience</td>
                    <td>
                        <input type="text" name="exp" value="${edit.exp}"/>
                    </td>
                </tr>
                <tr>
                    <td>Job Description</td>
                    <td>
                        <input type="text" name="des" value="${edit.des}" />
                    </td>
                </tr>
                <input type="hidden" name="id" value="${edit.id}"/>
                <tr>
                    <td>
                        <input type="submit" value="Update" />
                    </td>
                    <td>
                        <input type="submit" value="Return to Job List" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
