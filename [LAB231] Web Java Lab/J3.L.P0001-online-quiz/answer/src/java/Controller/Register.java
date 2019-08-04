/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entity.User;
import Model.UserModel;
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
 * Provide register function
 *
 * @author minhndse04560
 */
public class Register extends BaseServlet {

    @Override
    public String getFileName() {
        return "registerForm.jsp";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // This function is accessible to all user
        // even if user have logged in or not
        request.setAttribute("page", getFileName());
        getServletContext().getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = "registerForm.jsp";
        String message = "", messageClass = "failed";
        UserModel um = null;
        try {
            um = new UserModel();
            //Get user data from request
            String userNane = req.getParameter("username");
            String password = req.getParameter("password");
            String type = req.getParameter("type");
            String email = req.getParameter("email");

            req.setAttribute("savedUserName", userNane);
            req.setAttribute("savedEmail", email);
            req.setAttribute("savedType", Integer.parseInt(type));
            User newUser = new User(-1, userNane, password, email, Integer.parseInt(type));
            //Data validation
            int errorCode = um.validateNewUser(newUser);
            if (errorCode == 1) {
                message = "Username is already exist";
            } else if (errorCode == 2) {
                message = "Email is already exist";
            } else if (newUser.getPassword().length() < 8) {
                message = "Password must contain at least 8 character";
            } else { //If no error found, add user to database
                um.addUser(newUser);
                message = "User registered successwfilly";
                messageClass = "success";
            }

            req.setAttribute("page", page);
            req.setAttribute("message", message);
            req.setAttribute("messageClass", messageClass);
            getServletContext().getRequestDispatcher("/index.jsp")
                    .forward(req, resp);

        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            getServletContext().getRequestDispatcher("/errorPage/errorPage.jsp")
                    .forward(req, resp);
        }
    }
}
