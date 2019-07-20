/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author minhndse04560
 */
public abstract class BaseServlet extends HttpServlet {
    /**
     * Function that return JSP filename so that index.jsp can include
     * @return Name of the .jsp file
     */
    public abstract String getFileName();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        //Check if user have already logged in or not
        String userName = (String) session.getAttribute("user");
        
        //If user logged in, set filename to the required filename
        //If not, filename will be login form
        String page = "loginForm.jsp";
        if (userName != null) {
        String userType = (String) session.getAttribute("userType").toString();
            page = getFileName();
            if (isTeacherOnly()&&userType.equals("0"))
                page = "errorPage/accessDenied.jsp";
        }
        
        //index.jsp work as a masterpage
        //It will find page attribute in request, and include it in its predefined div
        request.setAttribute("page", page);
        getServletContext().getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }
    
    /**
     * This function determines if this servlet is only accessible to teacher
     * @return A boolean that indicates if this function is or teacher use only
     */
    public boolean isTeacherOnly() {
        return false;
    }
}
