<%-- 
    Document   : makeQuiz
    Created on : May 23, 2018, 11:00:21 AM
    Author     : minhndse04560
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String message = (String) request.getAttribute("message");
    String content = "";
    String opt1 = "";
    String opt2 = "";
    String opt3 = "";
    String opt4 = "";
    String[] answers = new String[4];
    if (message != null) {
        content = (String) request.getAttribute("content");
        opt1 = (String) request.getAttribute("opt1");
        opt2 = (String) request.getAttribute("opt2");
        opt3 = (String) request.getAttribute("opt3");
        opt4 = (String) request.getAttribute("opt4");
        String answer = (String) request.getAttribute("answer");
        for (int i = 0; i < answer.length(); i++) {
            char x = answer.charAt(i);
            int index = (int) x - 49;
            answers[index] = "checked";
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="resource/css/makeQuiz.css">
        <link rel="stylesheet" href="resource/css/common.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% if (message != null) {%>
        <span class="failed"><%=message%></span>
        <% }%>
        <form action="MakeQuiz" method="post">
            <table>
                <tbody>
                    <tr>
                        <td>Question: </td>
                        <td><textarea id="content" name="content"><%=content%></textarea></td>
                    </tr>
                    <tr>
                        <td>Option 1</td>
                        <td><textarea name="opt1"><%=opt1%></textarea></td>
                    </tr>
                    <tr>
                        <td>Option 2</td>
                        <td><textarea name="opt2" ><%=opt2%></textarea></td>
                    </tr>
                    <tr>
                        <td>Option 3</td>
                        <td><textarea name="opt3" ><%=opt3%></textarea></td>
                    </tr>
                    <tr>
                        <td>Option 4</td>
                        <td><textarea name="opt4"><%=opt4%></textarea></td>
                    </tr>
                    <tr>
                        <td>Answer(s)</td>
                        <td>
                            <input type="checkbox" name="ans1" <%=answers[0]%>> Option 1
                            <input type="checkbox" name="ans2" <%=answers[1]%>> Option 2
                            <input type="checkbox" name="ans3" <%=answers[2]%>> Option 3
                            <input type="checkbox" name="ans4" <%=answers[3]%>> Option 4
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Save"></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
