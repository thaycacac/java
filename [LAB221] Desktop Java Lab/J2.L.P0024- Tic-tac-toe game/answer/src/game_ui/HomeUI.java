package game_ui;

import game_client.ClientManager;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class HomeUI extends javax.swing.JFrame {

    private final ClientManager playerControl;
    private final DefaultListModel<String> listOnline;

    public HomeUI(ClientManager playerControl) {
        initComponents();
        setTitle("Caro Room");
        setResizable(false);
        setLocation(520, 220);
        listOnline = new DefaultListModel<>();
        jlistOnline.setModel(listOnline);
        this.playerControl = playerControl;
    }

    public int getGameSize() {
        return (int) boardSize.getValue();
    }

    public int getUserChoice(String from, int size) {
        return JOptionPane.showConfirmDialog(this, "Do you want to play Caro (" + size + "x" + size + ") with " +
                from + "?", "Invite", JOptionPane.YES_NO_OPTION);
    }

    public void removeUserFromList(String userName) {
        listOnline.removeElement(userName);
    }

    public void addUserToList(String userName) {
        listOnline.addElement(userName);
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jlistOnline = new javax.swing.JList<>();
        btnInvite = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        boardSize = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jScrollPane1.setViewportView(jlistOnline);

        btnInvite.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInvite.setText("Invite");
        btnInvite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInviteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Preferred board size:");

        boardSize.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boardSize.setModel(new javax.swing.SpinnerNumberModel(10, 3, 15, 1));
        boardSize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInvite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(boardSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInvite)
                    .addComponent(jLabel1)
                    .addComponent(boardSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInviteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInviteActionPerformed
        int idx = jlistOnline.getSelectedIndex();
        if (idx > 0) {
            playerControl.sendInvite(listOnline.getElementAt(idx));
        }
    }//GEN-LAST:event_btnInviteActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        playerControl.setOffline();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner boardSize;
    private javax.swing.JButton btnInvite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlistOnline;
    // End of variables declaration//GEN-END:variables
}
