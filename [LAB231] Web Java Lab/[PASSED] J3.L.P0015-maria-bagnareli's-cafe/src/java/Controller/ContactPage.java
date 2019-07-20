package Controller;

import entity.Contact;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.ContactDAO;

/**
 *
 * @author Thaycacac
 */
public class ContactPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ContactDAO contactDAO = new ContactDAO();

            Contact contactPhone = contactDAO.getContact("phone").get(0);
            Contact contactEmail = contactDAO.getContact("email").get(0);
            ArrayList<Contact> listWork = contactDAO.getContact("work");

            request.setAttribute("contactPhone", contactPhone);
            request.setAttribute("contactEmail", contactEmail);
            request.setAttribute("listWork", listWork);

            request.setAttribute("boldContact", "font-bold");

            request.getRequestDispatcher("/contact.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("Error", "Error");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
