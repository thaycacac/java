package controller;

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
public class ViewArticle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ArticleDAO articleDao = new ArticleDAO();
            // get most recent article
            Article mostRecentArticle = articleDao.getRecentArticle(1).get(0);
            request.setAttribute("mostRecentArticle", mostRecentArticle);
            ArrayList<Article> fiveRecentAticle = articleDao.getRecentArticle(5);
            request.setAttribute("fiveRecentAticle", fiveRecentAticle);

            Article article = articleDao.getArticleById(id);
            // check article exist or not
            if (article == null) {
                request.setAttribute("error", "Not found article");
                request.getRequestDispatcher("/search.jsp").forward(request, response);
            } else {
                request.setAttribute("articleCurrent", article);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("error", "Sorry! Error occurred");
            request.getRequestDispatcher("/search.jsp").forward(request, response);
        }
    }

}
