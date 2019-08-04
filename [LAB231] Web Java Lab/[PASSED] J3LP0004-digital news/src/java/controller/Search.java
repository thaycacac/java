package controller;

import entity.Article;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modal.ArticleDAO;

/**
 *
 * @author Thaycacac
 */
public class Search extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            final int ARTICLE_PAGE = 2;
            HttpSession session = request.getSession();

            int pageCurrent = Integer.parseInt(request.getParameter("page"));
            String keyword = (String) session.getAttribute("keyword");

            // get most and five recent article
            ArticleDAO articles = new ArticleDAO();
            Article mostRecentArticle = articles.getRecentArticle(1).get(0);
            request.setAttribute("mostRecentArticle", mostRecentArticle);
            ArrayList<Article> fiveRecentAticle = articles.getRecentArticle(5);
            request.setAttribute("fiveRecentAticle", fiveRecentAticle);

            // get list article found
            ArrayList<Article> listSearch = articles.getListAticleSearch(ARTICLE_PAGE, pageCurrent, keyword);
            request.setAttribute("listSearch", listSearch);

            // get number page to paging
            int numberPage = articles.getNumberPage(ARTICLE_PAGE, keyword);
            request.setAttribute("numberPage", numberPage);

            // get page current
            request.setAttribute("pageCurrent", pageCurrent);

            if (listSearch.size() == 0) {
                request.setAttribute("error", "Not found");
                request.getRequestDispatcher("/search.jsp").forward(request, response);
            }

            request.getRequestDispatcher("/search.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", "Sorry! Error occurred");
            request.getRequestDispatcher("/search.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String keyword = request.getParameter("keyword");

            // check keyword empty
            if (keyword == null || keyword.isEmpty()) {
                // refresh page 
                String servletPrev = request.getHeader("referer");
                String nameServletPrev = servletPrev.substring(servletPrev.lastIndexOf("/") + 1);
                response.sendRedirect(nameServletPrev);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("keyword", keyword);
                response.sendRedirect("Search?page=1");
            }
        } catch (Exception e) {
            request.setAttribute("error", "Sorry! Error occurred");
            request.getRequestDispatcher("/search.jsp").forward(request, response);
        }
    }
}
