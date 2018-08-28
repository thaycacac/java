package servlet;

import dal.JobDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thaycacac
 */
public class DeleteJobServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idSt = request.getParameter("id");
        JobDAO jobDao = new JobDAO();
        if (idSt == null) {
            response.sendRedirect(request.getContextPath() + "//ListJob.jsp");
        } else {
            int id = Integer.parseInt(idSt);
            jobDao.deleteJob(id);
            response.sendRedirect(request.getContextPath() + "//ListJob.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
