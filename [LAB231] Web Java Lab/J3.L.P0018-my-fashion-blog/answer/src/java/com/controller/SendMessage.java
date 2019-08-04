/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Message;
import com.model.MessageModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thuongnnse05095
 */
public class SendMessage extends HttpServlet {

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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            MessageModel model = new MessageModel();
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String message = request.getParameter("message");
            
            if(!model.checkEmail(email)){
                response.getWriter().write("email");
            }else if(!model.checkNull(name)){
                response.getWriter().write("name");
            }else if(!model.checkNull(message)){
                response.getWriter().write("message");
            }else{
                response.getWriter().write("true");
                Message data = new Message(name, email, message);
                model.insertDB(data);
            }
            
//            if (model.checkEmail(email) && model.checkNull(name) && model.checkNull(message)) {
//                response.getWriter().write("true");
//                Message data = new Message(name, email, message);
//                model.insertDB(data);
//            } else {
//                response.getWriter().write("false");
//            }
        } catch (Exception ex) {
            response.sendRedirect("error.jsp");
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
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
