package servlet;

import dal.QuizSessionDAO;
import dataobj.QuizSession;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thaycacac
 */
public class StudentEnterRoomServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String roomname = request.getParameter("roomname");

        QuizSessionDAO quizSessionDao = new QuizSessionDAO();
        QuizSession qs = quizSessionDao.getQuizSession(roomname);

        if (qs == null || !qs.getCode().equals(roomname)) {
            request.setAttribute("error", "Room name incorrect");
            request.getRequestDispatcher("/student/loginroom.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("quizSession", qs);

            request.getRequestDispatcher("/student/loginname.jsp").forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
