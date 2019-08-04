/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author thuongnnse05095
 */
public class CloseConnection {

    public void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null && rs.isClosed()) {
            rs.close();
        }
        if (ps != null && ps.isClosed()) {
            ps.close();
        }
        if (conn != null && conn.isClosed()) {
            conn.close();
        }
    }
}
