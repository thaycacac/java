/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.QuizHistoryModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Home page of application
 *
 * @author minhndse04560
 */
public class Index extends BaseServlet {

    @Override
    public String getFileName() {
        return "userInfo.jsp";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String user = (String) request.getSession().getAttribute("user");
            if (user != null) {
                int userType = Integer.parseInt(request.getSession().getAttribute("userType").toString());
                if (userType == 1) {

                    request.setAttribute("quizHistory", new QuizHistoryModel().getAllEntry());

                }
            }
            super.doGet(request, response);
        } catch (Exception ex) {
            Logger.getLogger(MakeQuiz.class.getName()).log(Level.SEVERE, null, ex);
            getServletContext().getRequestDispatcher("/errorPage/errorPage.jsp")
                    .forward(request, response);
        }
    }

}
