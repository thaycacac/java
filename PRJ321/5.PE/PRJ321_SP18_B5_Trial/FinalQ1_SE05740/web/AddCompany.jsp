<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Company</title>
    </head>
    <body>
        <h1>Add Company</h1>
        <form action="AddCompanyServlet" method="POST">
            <table border="1">
                <tr>
                    <td>Company Code</td>
                    <td>
                        <input type="text" name="code"/>
                    </td>
                </tr>
                <tr>
                    <td>Company Name</td>
                    <td>
                        <input type="text" name="name" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Add" />
                        <input type="submit" value="Return to Company List" formaction="ListCompanyServlet" formmethod="POST"/>
                    </td>
                    <td></td>
                </tr>
            </table>
        </form>
    </body>
</html>
