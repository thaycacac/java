
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thaycacac
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    DAO dao;
    DefaultTableModel dftm;

    public Main() {
        initComponents();
        dao = new DAO(new DBContext());
        dftm = new DefaultTableModel();
        loadTable();
        addItemCombobox();
        clickCombobox();
    }
    
    public void changeInfoClickRowIntable(){
        int currentRout = jTable1.getSelectedRow();
        String battle = jTable1.getValueAt(currentRout , 1).toString();
        try {
            String sql = "SELECT o.ship FROM dbo.Outcomes o\n"
                    + "WHERE o.battle = '" + battle + "'";
            ResultSet rs = dao.getData(sql);
            while (rs.next()) {
                tfShipName.setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            String sql = "SELECT o.result FROM dbo.Outcomes o\n"
                    + "WHERE o.battle = '" + battle + "'";
            ResultSet rs = dao.getData(sql);
            while (rs.next()) {
                tfNewResult.setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbSeclectBattle = new javax.swing.JLabel();
        jlbEnterShipName = new javax.swing.JLabel();
        jlbEnterNewResult = new javax.swing.JLabel();
        cbbSelectBattle = new javax.swing.JComboBox<>();
        tfShipName = new javax.swing.JTextField();
        tfNewResult = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlbSeclectBattle.setText("Select a battle");

        jlbEnterShipName.setText("Enter ship name");

        jlbEnterNewResult.setText("Enter new result");

        btnSearch.setText("Search");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ship Name", "Battle Name", "Result"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlbEnterNewResult)
                            .addComponent(jlbEnterShipName)
                            .addComponent(jlbSeclectBattle))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbSelectBattle, 0, 157, Short.MAX_VALUE)
                            .addComponent(tfShipName)
                            .addComponent(tfNewResult))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbSeclectBattle)
                    .addComponent(cbbSelectBattle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbEnterShipName)
                    .addComponent(tfShipName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbEnterNewResult)
                    .addComponent(tfNewResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        update();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        changeInfoClickRowIntable();
    }//GEN-LAST:event_jTable1MouseClicked

    public void addItemCombobox() {
        try {
            String sql = "SELECT o.battle FROM dbo.Outcomes o";
            ResultSet rs = dao.getData(sql);
            while (rs.next()) {
                cbbSelectBattle.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void clickCombobox() {
        setShip();
        setResult();
        cbbSelectBattle.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                setShip();
                setResult();
            }
        });
    }

    public void setShip() {
        try {
            String sql = "SELECT o.ship FROM dbo.Outcomes o\n"
                    + "WHERE o.battle = '" + cbbSelectBattle.getSelectedItem().toString() + "'";
            ResultSet rs = dao.getData(sql);
            while (rs.next()) {
                tfShipName.setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setResult() {
        try {
            String sql = "SELECT o.result FROM dbo.Outcomes o\n"
                    + "WHERE o.battle = '" + cbbSelectBattle.getSelectedItem().toString() + "'";
            ResultSet rs = dao.getData(sql);
            while (rs.next()) {
                tfNewResult.setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void loadTable() {
        String sql = "SELECT * FROM dbo.Outcomes";
        initTable(sql, dftm, jTable1);
    }

    public void initTable(String sql, DefaultTableModel dftm, JTable table) {
        try {
            ResultSet rs = dao.getData(sql);
            Object[] title = {"Ship Name", "Battle Name", "Result"};
            dftm.setColumnIdentifiers(title);
            dftm.setRowCount(0);
            while (rs.next()) {
                Vector vec = new Vector();
                vec.add(rs.getString(1));
                vec.add(rs.getString(2));
                vec.add(rs.getString(3));
                dftm.addRow(vec);
            }
            table.setModel(dftm);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    public void update() {
        try {
            PreparedStatement ps;
            String sql = "UPDATE dbo.Outcomes SET ship = ?, result = ? WHERE battle = ?";
            ps = dao.getPS(sql);
            ps.setString(1, tfShipName.getText());
            ps.setString(2, tfNewResult.getText());
            ps.setString(3, cbbSelectBattle.getSelectedItem().toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog( null, "Success");
            loadTable();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    

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
                if ("Nimbus".equals(info.getName())) {
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
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbbSelectBattle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlbEnterNewResult;
    private javax.swing.JLabel jlbEnterShipName;
    private javax.swing.JLabel jlbSeclectBattle;
    private javax.swing.JTextField tfNewResult;
    private javax.swing.JTextField tfShipName;
    // End of variables declaration//GEN-END:variables
}
