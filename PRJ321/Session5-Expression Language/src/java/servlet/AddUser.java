/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dal.UserDAO;
import dataobj.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thaycacac
 */
public class AddUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        boolean gender = ((request.getParameter("gender").equalsIgnoreCase("male")) ? true : false);
        UserDAO userDao = new UserDAO();
        User user = new User(username, firstname, lastname, password, email, gender);
        userDao.addUser(user);
        request.getRequestDispatcher("Login.jsp").forward(request,response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
