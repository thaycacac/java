/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.connect.DBContext;
import com.entity.Information;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thuongnnse05095
 */
public class InfoModel {

    private final DBContext db;

    public InfoModel() throws Exception {
        db = new DBContext();
    }

    public Information getInfoPage() throws Exception {
        String query = "select * from Information";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Information output = null;

        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String imgLink = db.getResource() + rs.getString(4);
                String content = rs.getString(5);
                output = new Information(id, name, age, imgLink, content);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            new CloseConnection().close(conn, ps, rs);
        }
        return output;
    }
}
