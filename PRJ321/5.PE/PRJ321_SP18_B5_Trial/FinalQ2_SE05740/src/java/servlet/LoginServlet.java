package servlet;

import dal.UserDAO;
import dataobj.User;
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
public class LoginServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(password);

        UserDAO udao = new UserDAO();
        User user = udao.getUser(username);
        System.out.println(user.getPass());
        if (user.getPass().equalsIgnoreCase(password)) {
            if (user.getRole() == 1) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                request.getRequestDispatcher("authen/AdminPage.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("authen/UserPage.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Invalid username and password, please retry");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
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
