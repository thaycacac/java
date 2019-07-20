/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.connect.DBContext;
import com.entity.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thuongnnse05095
 */
public class ArticleModel {

    private final DBContext db;

    public ArticleModel() throws Exception {
        db = new DBContext();
    }

    public List<Article> getArticlesFromTo(int page, int pageSize) throws Exception {
        int from = page * pageSize - (pageSize - 1);
        int to = page * pageSize;
        List<Article> articles = new ArrayList<>();
        String query = "select * from ("
                + "select *, ROW_NUMBER() over (order by id) as rownumber from Article"
                + ") as articles "
                + "where articles.rownumber >= ? and articles.rownumber <=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, from);
            ps.setInt(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String imgLink = db.getResource() + rs.getString(3);
                String content = rs.getString(4);
                String fullContent = rs.getString(5);
                articles.add(new Article(id, title, imgLink, content, fullContent));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.close(conn, ps, rs);
        }
        return articles;
    }

    public Article getDetailsPost(int id) throws Exception {
        String query = "select * from Article where id = ?";
        Article article = new Article();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                article.setId(rs.getInt(1));
                article.setTitle(rs.getString(2));
                article.setImgLink(db.getResource() + rs.getString(3));
                article.setContent(rs.getString(4));
                article.setFullContent(rs.getString(5));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.close(conn, ps, rs);
        }
        return article;
    }

    public int getTotalRows() throws Exception {
        int rows = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "select count(*) from Article";

        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                rows = rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.close(conn, ps, rs);
        }
        return rows;
    }

}
