package modal;

import db.DBContext;
import entity.Article;
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

    public ArrayList<Article> getArticle(int numberArticle, int typeArticle) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT TOP (?) * "
                + "FROM Article WHERE type = (?)"
                + "ORDER BY Date DESC";

        ArrayList<Article> listArticle = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, numberArticle);
            ps.setInt(2, typeArticle);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                int type = rs.getInt(2);
                String title = rs.getString(3);
                String content = rs.getString(4);
                String image = rs.getString(5);
                Date date = rs.getDate(6);

                Article article = new Article(id, type, title, content, image, date);
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
        String sql = "SELECT * FROM Article WHERE id = (?)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int type = rs.getInt(2);
                String title = rs.getString(3);
                String content = rs.getString(4);
                String image = rs.getString(5);
                Date date = rs.getDate(6);
                return new Article(id, type, title, content, image, date);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
        return null;
    }

    public ArrayList<Article> getListAticle(int numberArticleInPage, int pageCurrent) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Article> listArticle = new ArrayList<>();

        String sql = "SELECT * FROM (\n"
                + "SELECT ROW_NUMBER()\n"
                + "OVER(ORDER BY id) as Number,\n"
                + "* FROM Article \n"
                + ") as DataSearch where Number between ? and ?";
        try {
            db = new DBContext();
            int articleFrom = pageCurrent * numberArticleInPage - 1;
            int articleTo = articleFrom + numberArticleInPage - 1;

            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, articleFrom);
            ps.setInt(2, articleTo);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(2);
                int type = rs.getInt(3);
                String title = rs.getString(4);
                String content = rs.getString(5);
                String image = rs.getString(6);
                Date date = rs.getDate(7);
                Article article = new Article(id, type, title, content, image, date);
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

    public int getNumberPage(int numberArticleInPage) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Article> listArticle = new ArrayList<>();
        String sql = "SELECT COUNT(id) FROM Article";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
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
