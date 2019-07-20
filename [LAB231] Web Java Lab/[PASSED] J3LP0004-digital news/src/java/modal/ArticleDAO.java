package modal;

import entity.Article;
import db.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Thaycacac
 */
public class ArticleDAO {

    public ArrayList<Article> getRecentArticle(int numberArticle) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT TOP (?) * "
                + "FROM Article \n"
                + "ORDER BY Date DESC";

        ArrayList<Article> listArticle = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, numberArticle);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String image = db.getResource() + rs.getString(3);
                String content = rs.getString(4);
                Date date = rs.getDate(5);
                String author = rs.getString(6);
                Article article = new Article(id, title, image, content, date, author);
                listArticle.add(article);
            }
            return listArticle;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
    }

    public Article getArticleById(int id) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT title, image, content, date, author FROM Article WHERE id = ?";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                String title = rs.getString(1);
                String image = db.getResource() + rs.getString(2);
                String content = rs.getString(3);
                Date date = rs.getDate(4);
                String author = rs.getString(5);
                return new Article(id, title, image, content, date, author);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
        return null;
    }

    public ArrayList<Article> getListAticleSearch(int numberArticleInPage, int pageCurrent, String keyword) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Article> listArticle = new ArrayList<>();

        String sql = "SELECT * FROM (\n"
                + "SELECT ROW_NUMBER()\n"
                + "OVER(ORDER BY id) as Number,\n"
                + "* FROM Article \n"
                + "WHERE content LIKE ? OR title LIKE ? \n"
                + ") as DataSearch where Number between ? and ?";
        try {
            db = new DBContext();

            int articleFrom = pageCurrent * numberArticleInPage - 1;
            int articleTo = articleFrom + numberArticleInPage - 1;

            con = db.getConnection();
            ps = con.prepareStatement(sql);
            keyword = "%" + keyword + "%";
            ps.setString(1, keyword);
            ps.setString(2, keyword);
            ps.setInt(3, articleFrom);
            ps.setInt(4, articleTo);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(2);
                String title = rs.getString(3);
                String image = db.getResource() + rs.getString(4);
                String content = rs.getString(5);
                Date date = rs.getDate(6);
                String author = rs.getString(7);
                Article article = new Article(id, title, image, content, date, author);
                listArticle.add(article);
            }
            return listArticle;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
    }

    public int getNumberPage(int numberArticleInPage, String keyword) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Article> listArticle = new ArrayList<>();
        String sql = "SELECT COUNT(id) FROM Article \n"
                + "WHERE content\n"
                + "LIKE ? OR title LIKE ?";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            keyword = "%" + keyword + "%";
            ps.setString(1, keyword);
            ps.setString(2, keyword);
            rs = ps.executeQuery();

            while (rs.next()) {
                int numberArticle = rs.getInt(1);
                return (numberArticle + (numberArticle % numberArticleInPage)) / numberArticleInPage;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
        return -1;
    }
}
