package Controller;

import entity.Article;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.ArticleDAO;

/**
 *
 * @author Thaycacac
 */
public class About extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            final int ARTICLE_PAGE = 2;
            String stPageCurrent = request.getParameter("page");
            String stArticle = request.getParameter("article");

            ArticleDAO articleDAO = new ArticleDAO();

            if (stPageCurrent != null && !stPageCurrent.isEmpty()) {
                int intPageCurrent = Integer.parseInt(stPageCurrent);

                ArrayList<Article> listArticle = articleDAO.getListAticle(ARTICLE_PAGE, intPageCurrent);
                request.setAttribute("listArticle", listArticle);

                // get number page to paging
                int numberPage = articleDAO.getNumberPage(ARTICLE_PAGE);
                request.setAttribute("numberPage", numberPage);

                // get page current
                request.setAttribute("pageCurrent", intPageCurrent);

                // get page current header
                request.setAttribute("boldAbout", "font-bold");

                request.getRequestDispatcher("/about.jsp").forward(request, response);
            } else if (stArticle != null && !stArticle.isEmpty()) {
                int intArticle = Integer.parseInt(stArticle);
                Article article = articleDAO.getArticleById(intArticle);
                request.setAttribute("article", article);
                
                request.setAttribute("boldAbout", "font-bold");
                
                request.getRequestDispatcher("/article.jsp").forward(request, response);
            }
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
