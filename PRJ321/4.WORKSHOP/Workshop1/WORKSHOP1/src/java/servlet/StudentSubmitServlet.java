package servlet;

import dal.StudentQuizAnswerDAO;
import dataobj.Answer;
import dataobj.Question;
import dataobj.Quiz;
import dataobj.QuizSession;
import dataobj.Student;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thaycacac
 */
public class StudentSubmitServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        Student std = (Student) session.getAttribute("student");
        int studentId = std.getId();
        
        QuizSession qs = (QuizSession) session.getAttribute("quizSession");
        int sessionId = qs.getId();
        
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        int quizId = quiz.getId();
        
        ArrayList<Question> listQus = (ArrayList<Question>) session.getAttribute("listQus");
        
        StudentQuizAnswerDAO sqa = new StudentQuizAnswerDAO();
        
        int countAnsCorrect = 0;
        for (Question qus : listQus) {
            String qa = request.getParameter("q" + qus.getQuestionId());
            String[] qusans = qa.trim().split("-");
            String qusId = qusans[0];
            String ansId = qusans[1];
            
            sqa.addStudentQuizAnswer(studentId, sessionId,
                    quizId, qusId, ansId);
            
            String ansIdCorrect = ansIdCorrect(qus);
                       
            if (ansId.equalsIgnoreCase(ansIdCorrect)) {
                countAnsCorrect++;
            }
        }
        NumberFormat formatter = new DecimalFormat("#0.00");        
        double result = (double)countAnsCorrect / listQus.size() * 10;
        
        request.setAttribute("score", result);
        request.getRequestDispatcher("/student/result.jsp").forward(request, response);
    }
    
    private String ansIdCorrect(Question ques) {
        ArrayList<Answer> listAns = ques.getListAnswer();
        for (Answer ans : listAns) {
            if (ans.isIsCorrectAnswer()) {
                return String.valueOf(ans.getId());
            }
        }
        return null;
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
