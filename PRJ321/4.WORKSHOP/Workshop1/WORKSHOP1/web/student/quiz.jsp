<%@page import="dataobj.Answer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../myStyle.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <title>Play Quiz</title>
    </head>
    <body>
        <%!
            char[] charAnswer = {'A', 'B', 'C', 'D', 'E', 'G', 'H'};
        %>
        <div class="container">
            <div class="container-quiz">
                <h3>${quiz.title}</h3>
                <hr>
                <form action="StudentSubmit" method="POST">
                    <c:forEach var="question" items="${listQus}">
                        <p>${question.content}</p>
                        <ul class="list-group list-group-flush">
                            <% int count = 0;%>
                            <c:forEach var="answer" items="${question.listAnswer}">
                                <li class="list-group-item">
                                    <button type="button" class="btn btn-primary" disabled><%= charAnswer[count++]%></button>
                                    <input type="radio" name="q${question.questionId}" value="${question.questionId}-${answer.id}">${answer.content}
                                </li>
                            </c:forEach>
                        </ul>
                    </c:forEach>
                    <hr>
                    <button type="submit" class="btn btn-danger finish">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
