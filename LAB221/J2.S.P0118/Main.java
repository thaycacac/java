/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J2SP0118;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THAYCACAC
 */
public class Main {

    public static void main(String[] args) {

        Connection con = null;
        DAO dao = new DAO(new DBContext(), con);
        displayListTable(dao);
        displayProductName(dao);
        displayProductName(dao);
    }

    //print version of my sql server
    private static void displayProductVersion(DAO dao) {
        try {
            String sqlVersion = "Select @@version";
            ResultSet rs = dao.getData(sqlVersion);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.err.println("Database product version: ");
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) {
                        System.out.print(",  ");
                    }
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //print name of database
    private static void displayProductName(DAO dao) {
        try {
            String sqlVersion = "SELECT DB_NAME() AS [Current Database];  \n"
                    + "GO  ";
            ResultSet rs = dao.getData(sqlVersion);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.err.println("Database product name: ");
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) {
                        System.out.print(",  ");
                    }
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //print list table in databse
    private static void displayListTable(DAO dao) {
        try {
            String sqlVersion = "SELECT\n"
                    + "  t.TABLE_NAME\n"
                    + "FROM\n"
                    + "  INFORMATION_SCHEMA.TABLES t\n"
                    + "WHERE t.TABLE_TYPE = 'BASE TABLE'";
            ResultSet rs = dao.getData(sqlVersion);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.err.println("Listing tables in the database:");
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) {
                        System.out.print(",  ");
                    }
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
