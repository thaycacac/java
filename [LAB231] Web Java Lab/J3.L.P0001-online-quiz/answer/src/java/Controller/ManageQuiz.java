/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entity.Question;
import Model.QuestionModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Quiz listing function
 *
 * @author minhndse04560
 */
public class ManageQuiz extends BaseServlet {
    private static final int PAGE_SIZE = 3;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionModel qm = null;
        int page = (request.getParameter("p") == null) ? 1 : Integer.parseInt(request.getParameter("p"));
        try {
            //Get the question list from database, and add it to request
            qm = new QuestionModel();
            String req = (String) request.getParameter("del");
            if (req != null) {
                int id = Integer.parseInt(req);
                qm.deleteQueston(id);
            }
            int size = qm.getQuestionSize();
            request.setAttribute("quizData", getPage(qm, size, PAGE_SIZE, page));
            request.setAttribute("numOfQuiz", size);
            request.setAttribute("numOfPage", getNumOfPage(size, PAGE_SIZE));
            super.doGet(request, response);
        } catch (Exception ex) {
            Logger.getLogger(MakeQuiz.class.getName()).log(Level.SEVERE, null, ex);
            getServletContext().getRequestDispatcher("/errorPage/errorPage.jsp")
                    .forward(request, response);
        }
    }
    
    @Override
    public String getFileName() {
        return "manageQuiz.jsp";
    }
    
    @Override
    public boolean isTeacherOnly() {
        return true;
    }
    
    private int getNumOfPage(int listSize, int pageSize) {
        return (int) Math.ceil((double) listSize / (double) pageSize);
    }
    
    private List<Question> getPage(QuestionModel qm, int listSize, int pageSize, int pageNum) throws Exception {
        int numOfPage = getNumOfPage(listSize, pageSize);
        pageNum = (pageNum < numOfPage) ? pageNum - 1 : numOfPage - 1;
        int from = (pageNum * pageSize) + 1;
        int to = Math.min(((pageNum + 1) * pageSize), listSize) + 1;
        return qm.getQuestionsInRange(from, to);
    }
}
