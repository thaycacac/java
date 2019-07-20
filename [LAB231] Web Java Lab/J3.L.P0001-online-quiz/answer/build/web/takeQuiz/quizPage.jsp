<%-- 
    Document   : quizPage.jsp
    Created on : May 25, 2018, 11:42:33 AM
    Author     : minhndse04560
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Entity.Question"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String userName = (String) session.getAttribute("user");
    List<Question> questions = (List<Question>) request.getAttribute("quizData");
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="resource/css/quizPage.css">
        <link rel="stylesheet" href="resource/css/common.css">
        <script src="resource/js/quizPage.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="quizContainer">
            <% if (!questions.isEmpty()) {%>
            <h3>Welcome <span class="userName"><%=userName%></span></h3>
            <h4 id="TimeSpan">Time remaining: <span id="timeDisplay">00:00</span></h4>
            <h5 id="qustionPos">Question: 0/0</h5>
            <form id="quizForm" action="TakeQuiz" method="post">
                <input type="hidden" name="req" value="quizResult">
                <input type="hidden" name="numOfQuiz" value="<%=questions.size()%>">
                <%
                    for (int i = 0; i < questions.size(); i++) {
                        Question q = questions.get(i);
                %>
                <div id="q<%=i%>" class="hidden">
                    <input type="hidden" name="q<%=i%>" value="<%=q.getId()%>"
                           <p><%=q.getContent()%></p>
                    <ul>
                        <%
                            for (int j = 0; j < q.getOption().size(); j++) {
                                String ans = q.getOption().get(j);
                        %>
                        <input type="checkbox" name="ans<%=i%>-<%=j%>">
                        <li><%=ans%></li><br>
                            <% } %>
                    </ul>
                </div>
                <% } %>
                <input type="submit" value="Finish">    
                <button id="next" type="button" onclick="nextQuestion()">Next</button>
            </form>
            <% } else { %>
            <h3>No quiz found</h3>
            <% }%>
        </div>
        <script>
            setNumOfQuiz(<%=questions.size()%>);
            quizStart();
        </script>
    </body>
</html>
