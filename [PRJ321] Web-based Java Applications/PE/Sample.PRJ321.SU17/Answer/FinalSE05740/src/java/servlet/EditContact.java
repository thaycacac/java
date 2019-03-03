/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dal.ContactDAO;
import dataobj.Contact;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thaycacac
 */
public class EditContact extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        Contact cont = new ContactDAO().getContact(id);
        request.setAttribute("stu", cont);
        request.getRequestDispatcher("EditContact.jsp").forward(request, response);
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
        int id = Integer.parseInt(request.getParameter("id"));
        String fir = request.getParameter("fir");
        String las = request.getParameter("las");
        String group = request.getParameter("group");
        String phone = request.getParameter("phone");
        System.out.println(id);
        int phonei = 0;
        try {
            phonei = Integer.parseInt(phone);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Phone must be input number");
            request.getRequestDispatcher("AddContact.jsp").forward(request, response);
        }
        if (fir.trim().isEmpty() || fir == null
                || las.trim().isEmpty() || las == null) {
            request.setAttribute("error", "You must be fill all field");
            request.getRequestDispatcher("AddContact.jsp").forward(request, response);
        }
        int gri = Integer.parseInt(group);
        ContactDAO cd = new ContactDAO();
        cd.edit(id, fir, las, phonei, gri);
                response.sendRedirect(request.getContextPath()+"/ReListContact");

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
