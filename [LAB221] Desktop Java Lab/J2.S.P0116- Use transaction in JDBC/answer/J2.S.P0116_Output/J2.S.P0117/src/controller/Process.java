/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import display.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguyenvanan
 */
public class Process {

    Display f1;
    Insert f2;
//  some
    DefaultTableModel dftb;
    HashSet hs;

    public Process() {
    }

    public Process(Display f1) {
        this.f1 = f1;
        dftb = new DefaultTableModel();
        hs = new HashSet();
        f1.getTabel_show().getTableHeader().setReorderingAllowed(false);
    }

    public void controller() throws Exception {
        DataToTable();
        f1.setVisible(true);
        f1.getBtn_insert().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InsertToDB();
                } catch (Exception ex) {
                    System.out.println("shit happened");
                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
        Process pr = new Process(new Display());
        pr.controller();
    }
    int tableRows;

    // function
    public void DataToTable() throws Exception {
        Object[] title = {"StockID", "StockName", "Address", "DateAvailable", "Note"};
        Object[][] data = {
            {"1", "Stock 1", "Ha Noi", "2018-02-04", "Nah"},
            {"2", "Stock 2", "Ha Long", "2018-02-04", "Nah"},
            {"3", "Stock 3", "HCM city", "2018-02-04", "no"},
            {"4", "Stock 4", "Hai Phong", "2018-02-04", "Nah"},
            {"5", "Stock 5", "Da Nang", "2018-02-04", "Nah"}
        };
        tableRows = data.length;
        dftb.setDataVector(data, title);
        f1.getTabel_show().setModel(dftb);
    }

    public void InsertToDB() throws SQLException, Exception {
        Connection conn;
        conn = new DBContext().getConnection();
        try {
            String sql = "INSERT INTO dbo.Stocks(StockID, StockName, Address, DateAvailable, Note) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            for (int i = 0; i < tableRows; i++) {
                pstm.setInt(1, Integer.parseInt(dftb.getValueAt(i, 0).toString()));
                pstm.setString(2, dftb.getValueAt(i, 1).toString());
                pstm.setString(3, dftb.getValueAt(i, 2).toString());
                pstm.setString(4, dftb.getValueAt(i, 3).toString());
                pstm.setString(5, dftb.getValueAt(i, 4).toString());
                //  pstm.addBatch();
                // this part is using transaction process to insert data into DB
                pstm.executeUpdate();
            }
            // this part is using batch processing to insert data into DB
//            int[] count = pstm.executeBatch();
//            pstm.clearBatch();
//            System.out.println(Arrays.toString(count));
            conn.commit();
            System.out.println("Success insert");

        } catch (SQLException esql) {
            conn.rollback();
            System.out.println("Roll back");
        } catch (NumberFormatException ae) {
        } finally {
            conn.close();
            f1.getTabel_show().setEnabled(false);
        }
    }
}
