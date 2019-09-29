
import javax.swing.BorderFactory;
import static javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

public class Main extends javax.swing.JFrame {

    int x, y;

    public Main() {
        initComponents();
        jpnOut.setBackground(Color.WHITE);
        jpnOut.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        jpnIn.setBackground(Color.RED);
        x = jpnIn.getX();
        y = jpnIn.getY();
        setKey();
    }

    public void setKey() {
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "down", KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (y <= jpnOut.getHeight()) {
                    jpnIn.setLocation(x, y + 2);
                    y += 2;
                }
            }
        });
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "up", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (y >= 0) {
                    jpnIn.setLocation(x, y - 2);
                    y -= 2;
                }
            }
        });
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "left", KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (x >= 0) {
                    jpnIn.setLocation(x - 2, y);
                    x -= 2;
                }
            }
        });
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "right", KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (x <= jpnOut.getWidth()) {
                    jpnIn.setLocation(x + 2, y);
                    x += 2;
                }
            }
        });
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "press", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("enter");
            }
        });
    }

    public void bindKeyStrokeTo(int condition, String name, KeyStroke keyStroke, Action action) {
        InputMap im = jpnOut.getInputMap(condition);
        ActionMap am = jpnOut.getActionMap();

        im.put(keyStroke, name);
        am.put(name, action);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnOut = new javax.swing.JPanel();
        jpnIn = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpnInLayout = new javax.swing.GroupLayout(jpnIn);
        jpnIn.setLayout(jpnInLayout);
        jpnInLayout.setHorizontalGroup(
            jpnInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );
        jpnInLayout.setVerticalGroup(
            jpnInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnOutLayout = new javax.swing.GroupLayout(jpnOut);
        jpnOut.setLayout(jpnOutLayout);
        jpnOutLayout.setHorizontalGroup(
            jpnOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnOutLayout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addComponent(jpnIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        jpnOutLayout.setVerticalGroup(
            jpnOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnOutLayout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addComponent(jpnIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JPanel jpnIn;
    private javax.swing.JPanel jpnOut;
    // End of variables declaration//GEN-END:variables

}
