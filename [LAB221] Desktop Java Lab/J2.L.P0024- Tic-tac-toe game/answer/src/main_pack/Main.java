package main_pack;

import game_client.ClientManager;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Hoang Le
 * @rollNo SE04739
 * @version 1.0
 * @since 2018/08/10
 */
public final class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            ClientManager playerControl = new ClientManager();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            // ignore this
        }
    }

}
