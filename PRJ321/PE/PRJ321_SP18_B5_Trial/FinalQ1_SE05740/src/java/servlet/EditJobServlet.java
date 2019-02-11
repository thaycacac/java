package servlet;

import dal.JobDAO;
import dataobj.Job;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thaycacac
 */
public class EditJobServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("afsdfsfsdfsfsf");
        String intSt = request.getParameter("id");
        System.out.println(intSt);
        if (intSt == null) {
            request.getRequestDispatcher("EditJob").forward(request, response);
        } else {
            int id = Integer.parseInt(intSt);

            JobDAO jobDao = new JobDAO();
            Job job = jobDao.selectJobById(id);
            request.setAttribute("edit", job);
            response.sendRedirect(request.getContextPath() + "//EditJob.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
