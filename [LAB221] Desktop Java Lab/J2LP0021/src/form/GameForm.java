package form;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Thaycacac
 */
public class GameForm extends javax.swing.JFrame {
    private int count = 0;
    private int time;
    private int size = 3;
    private int positionCurrent;
    private int positionEmpty;
    private boolean flag = false;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSizeGame() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPositionCurrent() {
        return positionCurrent;
    }

    public void setPositionCurrent(int positionCurrent) {
        this.positionCurrent = positionCurrent;
    }

    public int getPositionEmpty() {
        return positionEmpty;
    }

    public void setPositionEmpty(int positionEmpty) {
        this.positionEmpty = positionEmpty;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public JButton getBtnNewGame() {
        return btnNewGame;
    }

    public void setBtnNewGame(JButton btnNewGame) {
        this.btnNewGame = btnNewGame;
    }

    public JComboBox<String> getCbbSize() {
        return cbbSize;
    }

    public void setCbbSize(JComboBox<String> cbbSize) {
        this.cbbSize = cbbSize;
    }

    public JPanel getJpnGame() {
        return jpnGame;
    }

    public void setJpnGame(JPanel jpnGame) {
        this.jpnGame = jpnGame;
    }

    public JLabel getTxtCount() {
        return txtCount;
    }

    public void setTxtCount(JLabel txtCount) {
        this.txtCount = txtCount;
    }

    public JLabel getTxtElapsed() {
        return txtElapsed;
    }

    public void setTxtElapsed(JLabel txtElapsed) {
        this.txtElapsed = txtElapsed;
    }
    
    
    
    public GameForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnGame = new javax.swing.JPanel();
        jpnMission = new javax.swing.JPanel();
        lbCount = new javax.swing.JLabel();
        lbElapsed = new javax.swing.JLabel();
        lbSize = new javax.swing.JLabel();
        txtCount = new javax.swing.JLabel();
        txtElapsed = new javax.swing.JLabel();
        cbbSize = new javax.swing.JComboBox<>();
        btnNewGame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpnGameLayout = new javax.swing.GroupLayout(jpnGame);
        jpnGame.setLayout(jpnGameLayout);
        jpnGameLayout.setHorizontalGroup(
            jpnGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnGameLayout.setVerticalGroup(
            jpnGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );

        lbCount.setText("Move count:");

        lbElapsed.setText("Elapsed:");

        lbSize.setText("Size:");

        txtCount.setText("0");

        txtElapsed.setText("0 sec");

        cbbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9" }));

        btnNewGame.setText("New game");

        javax.swing.GroupLayout jpnMissionLayout = new javax.swing.GroupLayout(jpnMission);
        jpnMission.setLayout(jpnMissionLayout);
        jpnMissionLayout.setHorizontalGroup(
            jpnMissionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMissionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnMissionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnMissionLayout.createSequentialGroup()
                        .addComponent(lbCount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCount))
                    .addGroup(jpnMissionLayout.createSequentialGroup()
                        .addComponent(lbElapsed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtElapsed))
                    .addGroup(jpnMissionLayout.createSequentialGroup()
                        .addComponent(lbSize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNewGame))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jpnMissionLayout.setVerticalGroup(
            jpnMissionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMissionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnMissionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCount)
                    .addComponent(txtCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnMissionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbElapsed)
                    .addComponent(txtElapsed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnMissionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSize)
                    .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btnNewGame))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnMission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnMission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewGame;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JPanel jpnGame;
    private javax.swing.JPanel jpnMission;
    private javax.swing.JLabel lbCount;
    private javax.swing.JLabel lbElapsed;
    private javax.swing.JLabel lbSize;
    private javax.swing.JLabel txtCount;
    private javax.swing.JLabel txtElapsed;
    // End of variables declaration//GEN-END:variables
}
