package Controller;

import entity.Article;
import entity.Contact;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.ArticleDAO;
import modal.ContactDAO;

/**
 *
 * @author Thaycacac
 */
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArticleDAO articleDAO = new ArticleDAO();
            ContactDAO contactDAO = new ContactDAO();

            Article articleIntroduction = articleDAO.getArticle(1, 1).get(0);
            Article articleLeft = articleDAO.getArticle(2, 2).get(0);
            Article articleRight = articleDAO.getArticle(2, 2).get(1);

            request.setAttribute("articleIntroduction", articleIntroduction);
            request.setAttribute("articleLeft", articleLeft);
            request.setAttribute("articleRight", articleRight);

            Contact contactAddress = contactDAO.getContact("address").get(0);
            Contact contactPhone = contactDAO.getContact("phone").get(0);

            request.setAttribute("contactAddress", contactAddress);
            request.setAttribute("contactPhone", contactPhone);

            request.setAttribute("boldHome", "font-bold");

            request.getRequestDispatcher("/index.jsp").forward(request, response);
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
