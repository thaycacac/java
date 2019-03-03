
import java.awt.Color;

/**
 *
 * @author THAYCACAC
 */
public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rdbRed = new javax.swing.JRadioButton();
        rebBlue = new javax.swing.JRadioButton();
        rdbGreen = new javax.swing.JRadioButton();
        rdbBlack = new javax.swing.JRadioButton();
        jpnBackground = new javax.swing.JPanel();
        jlbText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(rdbRed);
        rdbRed.setText("Red");
        rdbRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbRedActionPerformed(evt);
            }
        });

        buttonGroup1.add(rebBlue);
        rebBlue.setText("Blue");
        rebBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rebBlueActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbGreen);
        rdbGreen.setText("Green");
        rdbGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbGreenActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbBlack);
        rdbBlack.setText("Black");
        rdbBlack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbBlackActionPerformed(evt);
            }
        });

        jlbText.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jpnBackgroundLayout = new javax.swing.GroupLayout(jpnBackground);
        jpnBackground.setLayout(jpnBackgroundLayout);
        jpnBackgroundLayout.setHorizontalGroup(
            jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBackgroundLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlbText)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jpnBackgroundLayout.setVerticalGroup(
            jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbRed)
                    .addComponent(rebBlue)
                    .addComponent(rdbGreen)
                    .addComponent(rdbBlack)
                    .addComponent(jpnBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdbRed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rebBlue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbGreen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbBlack)
                .addGap(18, 18, 18)
                .addComponent(jpnBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbGreenActionPerformed
        jpnBackground.setBackground(Color.GREEN);
        jlbText.setText("Green is selected");
        jlbText.setForeground(Color.WHITE);
    }//GEN-LAST:event_rdbGreenActionPerformed

    private void rdbBlackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbBlackActionPerformed
        jpnBackground.setBackground(Color.BLACK);
        jlbText.setText("Black is selected");
        jlbText.setForeground(Color.WHITE);
    }//GEN-LAST:event_rdbBlackActionPerformed

    private void rebBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rebBlueActionPerformed
        jpnBackground.setBackground(Color.BLUE);
        jlbText.setText("Blue is selected");
        jlbText.setForeground(Color.WHITE);
    }//GEN-LAST:event_rebBlueActionPerformed

    private void rdbRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbRedActionPerformed
        jpnBackground.setBackground(Color.RED);
        jlbText.setText("Red is selected");
        jlbText.setForeground(Color.WHITE);
    }//GEN-LAST:event_rdbRedActionPerformed

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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jlbText;
    private javax.swing.JPanel jpnBackground;
    private javax.swing.JRadioButton rdbBlack;
    private javax.swing.JRadioButton rdbGreen;
    private javax.swing.JRadioButton rdbRed;
    private javax.swing.JRadioButton rebBlue;
    // End of variables declaration//GEN-END:variables
}
