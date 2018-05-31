
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author THAYCACAC
 */
public class AOutCome extends javax.swing.JFrame {

    Timer time;

    public AOutCome() {
        initComponents();
        initTime(); 
    }

    private void initTime() {
        time = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                changeColor();
            }
        });
    }

    private void changeColor() {
        Color color = lbResult.getForeground();
        if (color == Color.BLUE) {
            lbResult.setForeground(Color.RED);
        } else {
            lbResult.setForeground(Color.BLUE);
            displayTime();
        }
    }

    int start;

    private void displayTime() {
        lbTime.setText(start + "");
        start -= Integer.parseInt(tfStep.getText());

        if (start < Integer.parseInt(tfTo.getText())) {
            time.stop();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbResult = new javax.swing.JLabel();
        lbForm = new javax.swing.JLabel();
        tfFrom = new javax.swing.JTextField();
        lbTo = new javax.swing.JLabel();
        tfTo = new javax.swing.JTextField();
        lbStep = new javax.swing.JLabel();
        tfStep = new javax.swing.JTextField();
        btnStart = new javax.swing.JButton();
        lbTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbResult.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbResult.setForeground(new java.awt.Color(0, 0, 255));
        lbResult.setText("Java is cool");

        lbForm.setText("Form");

        tfFrom.setText("10");
        tfFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFromActionPerformed(evt);
            }
        });

        lbTo.setText("To");

        tfTo.setText("1");

        lbStep.setText("Step");

        btnStart.setText("Start");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbResult)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbForm)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfFrom))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbStep)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfStep, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(48, 48, 48)
                                .addComponent(lbTo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btnStart)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTime)
                            .addComponent(tfTo))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbResult)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbForm)
                    .addComponent(tfFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTo)
                    .addComponent(tfTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbStep)
                    .addComponent(tfStep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart)
                    .addComponent(lbTime))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFromActionPerformed

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
            java.util.logging.Logger.getLogger(AOutCome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AOutCome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AOutCome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AOutCome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AOutCome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel lbForm;
    private javax.swing.JLabel lbResult;
    private javax.swing.JLabel lbStep;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbTo;
    private javax.swing.JTextField tfFrom;
    private javax.swing.JTextField tfStep;
    private javax.swing.JTextField tfTo;
    // End of variables declaration//GEN-END:variables
}
