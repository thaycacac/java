<%-- 
    Document   : userInfo
    Created on : May 21, 2018, 12:01:38 PM
    Author     : minhndse04560
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Model.Entity.QuizHistory"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String userName = (String) session.getAttribute("user");
    String email = (String) session.getAttribute("email");
    int type = Integer.parseInt(session.getAttribute("userType").toString());
    String userType = (type == 1) ? "Teacher" : "Student";
    List<QuizHistory> history = null;
    if (type == 1) {
        history = (List<QuizHistory>) request.getAttribute("quizHistory");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resource/css/common.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User Information</h1>
        Username: <%=userName%><br>
        Email: <%=email%><br>
        Type: <%=userType%><br>
        <%
            if ((type == 1) && (history != null)) {
                if (history.size() != 0) {
        %>
        <table>
            <h3>Quiz history<br></h3>
            <thead>
                <tr>
                    <th>Student</th>
                    <th>Total</th>
                    <th>Correct</th>
                    <th>Mark</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <% for (QuizHistory q : history) { %>
                <%
                    double mark = (double) q.getCorrectAnswer() / (double) q.getNumOfQuiz();
                    mark *= 10;
                    NumberFormat formatter = new DecimalFormat("#0.00");
                %>
                <tr>
                    <td><%=q.getStudentName()%></td>
                    <td><%=q.getNumOfQuiz()%></td>
                    <td><%=q.getCorrectAnswer()%></td>
                    <td><%=formatter.format(mark)%></td>
                    <td><%=(mark > 4) ? "Passed" : "Failed"%></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <% } else { %>
        <span>No quiz history found</span>
        <% } %>
        <% }%>
    </body>
</html>
