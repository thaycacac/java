/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.connect.DBContext;
import com.entity.Home;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thuongnnse05095
 */
public class HomeModel {

    private final DBContext db;

    public HomeModel() throws Exception {
        db = new DBContext();
    }

    public Home getDetailsPost(int id) throws Exception {

        Home home = null;
        String query = "select * from Home where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idPost = rs.getInt(1);
                String type = rs.getString(2);
                String title = rs.getString(3);
                String imgLink = db.getResource() + rs.getString(4);
                String content = rs.getString(6);
                String createDate = formatDate("dd-MM-yyyy", rs.getString(7));
                System.out.println(rs.getString(7));
                home = new Home(idPost, type, title, imgLink, content, createDate);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            new CloseConnection().close(conn, ps, rs);
        }
        return home;
    }

    public ArrayList<Home> getPost(int page, int pageSize) throws Exception {
        int from = page * pageSize - (pageSize - 1);
        int to = page * pageSize;
        ArrayList<Home> homes = new ArrayList<>();
        String query = "select * from "
                + "( select *, ROW_NUMBER() over (order by createDate) as rownumber from Home) "
                + "as home where home.rownumber >= ? and home.rownumber <= ?";
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
                int idPost = rs.getInt(1);
                String type = rs.getString(2);
                String title = rs.getString(3);
                String imgLink = db.getResource() + rs.getString(4);
                String content = rs.getString(5); // get short content
                String createDate = formatDate("dd-MM-yyyy", rs.getString(7));
                int like = rs.getInt(8);
                int comment = rs.getInt(9);
                String titleGroup = formatDate("MMMM yyyy", rs.getString(7));
                System.out.println(rs.getString(7));
                Home home
                        = new Home(idPost, type, title, imgLink, content, createDate, like, comment, titleGroup);
                homes.add(home);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            new CloseConnection().close(conn, ps, rs);
        }
        return homes;
    }

    public int getNumPage(int pageSize, String query) throws SQLException {
        int totalPage = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                totalPage = rs.getInt(1);
            }

            if (totalPage % pageSize == 0) { // calculator total page to show information
                totalPage = totalPage / pageSize;
            } else {
                totalPage = totalPage / pageSize + 1;
            }
        } catch (Exception ex) {
            Logger.getLogger(HomeModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new CloseConnection().close(conn, ps, rs);
        }
        return totalPage;
    }

    public int getTotalPage(int pageSize) throws SQLException {
        String query = "select count(*) from Home";
        return getNumPage(pageSize, query);
    }

    public String formatDate(String pattern, String input) throws ParseException {
        Date date;
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = df.parse(input);
        } catch (ParseException ex) {
            throw ex;
        }
        return format.format(date);
    }
}
