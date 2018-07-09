package J2SP0114;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THAYCACAC
 */
public class Main extends javax.swing.JFrame {

    DAO dao;
    DefaultTableModel dftb;
    HashSet hs;

    public Main() {
        initComponents();
        Connection con = null;
        dao = new DAO(new DBContext(), con);
        dftb = new DefaultTableModel();
        hs = new HashSet();
    }

    public void createDB() {
        try {
            String sql = "CREATE DATABASE FU_DB";
            ResultSet rs = dao.getData(sql);
        } catch (Exception e) {
        }
    }

    public void createTable() {
        try {
            String sql = "CREATE TABLE Stocks(\n"
                    + "	StockID INT PRIMARY KEY,\n"
                    + "	StockName NVARCHAR(30),\n"
                    + "	[Address] NVARCHAR(45),\n"
                    + "	DateAvailable DATE,\n"
                    + "	Note NVARCHAR(45)\n"
                    + ")";
            ResultSet rs = dao.getData(sql);
        } catch (Exception e) {
        }
    }

    public void insertData() {
        String sql = "INSERT dbo.Stocks(StockID, StockName, Address, DateAvailable, Note)\n"
                + "VALUES(1, N'Stock one', N'No1 - Wasington', GETDATE(), N'')\n"
                + "INSERT dbo.Stocks(StockID, StockName, Address, DateAvailable, Note)\n"
                + "VALUES(2, N'Stock two', N'372 Cave town', GETDATE(), N'')\n"
                + "INSERT dbo.Stocks(StockID, StockName, Address, DateAvailable, Note)\n"
                + "VALUES(3, N'Stock three', N'Nary angle - 890', GETDATE(), N'Store dangerous')\n"
                + "INSERT dbo.Stocks( StockID, StockName, Address, DateAvailable, Note)\n"
                + "VALUES(4, N'Stock four', N'Twin tower - 01', GETDATE(), N'')\n"
                + "INSERT dbo.Stocks(StockID, StockName, Address, DateAvailable, Note)\n"
                + "VALUES(5, N'Stock five', N'Victory anniversary', GETDATE(), N'')";
        ResultSet rs = dao.getData(sql);
    }

    public void displayData() {
        try {
            String sql = "SELECT * FROM dbo.Stocks";
            ResultSet rs = dao.getData(sql);
            Object[] title = {"StockID", "StockName", "Address", "DateAvailable", "Note"};
            dftb.setColumnIdentifiers(title);
            dftb.setRowCount(0);
            hs.clear();
            while (rs.next()) {
                Vector vector = new Vector();
                vector.add(rs.getString(1));
                hs.add(rs.getString(1));
                vector.add(rs.getString(2));
                vector.add(rs.getString(3));
                vector.add(rs.getString(4));
                vector.add(rs.getString(5));
                dftb.addRow(vector);
            }
            tbStock.setModel(dftb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbStock = new javax.swing.JTable();
        btnCreateDB = new javax.swing.JButton();
        btnCreateTable = new javax.swing.JButton();
        btnInsertData = new javax.swing.JButton();
        btnDisplay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbStock);

        btnCreateDB.setText("Create DB");
        btnCreateDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateDBActionPerformed(evt);
            }
        });

        btnCreateTable.setText("Create Table");
        btnCreateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateTableActionPerformed(evt);
            }
        });

        btnInsertData.setText("Insert Data");
        btnInsertData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertDataActionPerformed(evt);
            }
        });

        btnDisplay.setText("Display Data");
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnCreateDB)
                .addGap(35, 35, 35)
                .addComponent(btnCreateTable)
                .addGap(35, 35, 35)
                .addComponent(btnInsertData)
                .addGap(40, 40, 40)
                .addComponent(btnDisplay)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateDB)
                    .addComponent(btnCreateTable)
                    .addComponent(btnInsertData)
                    .addComponent(btnDisplay))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateDBActionPerformed
        createDB();
    }//GEN-LAST:event_btnCreateDBActionPerformed

    private void btnCreateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateTableActionPerformed
        createTable();
    }//GEN-LAST:event_btnCreateTableActionPerformed

    private void btnInsertDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertDataActionPerformed
        insertData();
    }//GEN-LAST:event_btnInsertDataActionPerformed

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
        displayData();
    }//GEN-LAST:event_btnDisplayActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateDB;
    private javax.swing.JButton btnCreateTable;
    private javax.swing.JButton btnDisplay;
    private javax.swing.JButton btnInsertData;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbStock;
    // End of variables declaration//GEN-END:variables
}
