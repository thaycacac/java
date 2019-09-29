package game_ui;

import game_server.GamePlayManager;
import button.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class GamePlayUI extends javax.swing.JFrame {

    private final GamePlayManager gamePlayControl;

    public GamePlayUI(GamePlayManager gamePlayControl) {
        initComponents();
        setTitle("Caro Game");
        setResizable(false);
        setLocation(320, 130);
        this.gamePlayControl = gamePlayControl;
        setTxtPlayer(gamePlayControl.getUserName() + ": " + gamePlayControl.getTeam() + "-player");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public void setTxtPlayer(String text) {
        txtPlayer.setText(gamePlayControl.getUserName() + ": " + gamePlayControl.getTeam() + "-player");
    }

    public void setTextTurn(String turn) {
        txtTurn.setText(turn);
    }

    public void clearGameTable(int limit) {
        for (int i = 0; i < gamePlayControl.getListButton().size(); i++) {
            JLabel lbl = gamePlayControl.getListButton().get(i).getButton();
            gamePlayControl.getListButton().get(i).setStatus("*");
            lbl.setText("" + i);
            lbl.setFont(new Font("Tahoma", Font.PLAIN, 0));
        }
    }

    public void drawGameTable(int size, int limit) {
        int row = 0;
        int col;
        int countRow = 0;
        panelGame.setLayout(new GridLayout(size, size, 3, 3));
        // loop will run from 0 to value = @limit variable 
        for (int i = 0; i < limit; i++) {
            JLabel lbl = new JLabel("" + i);
            lbl.setFont(new Font("Tahoma", Font.PLAIN, 0));
            Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);
            lbl.setBorder(border);
            col = (i % size); // col = ( index mod size)
            // row = 0 if index mod board size = board size -1 increase row by 1
            if (countRow == size) {
                row++;
                countRow = 0;
            }
            countRow++;
            gamePlayControl.getListButton().put(i, new MyButton(i, lbl, row, col));
            // add mouse event for this button
            lbl.addMouseListener(new ButtonEvent(gamePlayControl));
            addButton(lbl);
        }
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Notification", JOptionPane.INFORMATION_MESSAGE);
    }

    public void addButton(JLabel button) {
        panelGame.add(button);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPlayer = new javax.swing.JLabel();
        txtTurn = new javax.swing.JLabel();
        panelGame = new javax.swing.JPanel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtPlayer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtPlayer.setText("A: X-Player");

        txtTurn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtTurn.setText("Turn: O");

        panelGame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelGame.setPreferredSize(new java.awt.Dimension(560, 560));

        javax.swing.GroupLayout panelGameLayout = new javax.swing.GroupLayout(panelGame);
        panelGame.setLayout(panelGameLayout);
        panelGameLayout.setHorizontalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        panelGameLayout.setVerticalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(txtPlayer)
                        .addGap(18, 18, 18)
                        .addComponent(txtTurn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(panelGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlayer)
                    .addComponent(txtTurn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        gamePlayControl.exitGame(gamePlayControl.getUserName());
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelGame;
    private javax.swing.JLabel txtPlayer;
    private javax.swing.JLabel txtTurn;
    // End of variables declaration//GEN-END:variables
}
