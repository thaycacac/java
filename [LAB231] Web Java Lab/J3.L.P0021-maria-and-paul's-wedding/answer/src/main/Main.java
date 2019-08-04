package main;

import controller.Controller;
import form.GameForm;
import java.util.HashMap;
import javax.swing.JButton;

/**
 *
 * @author Thaycacac
 */
public class Main {
    public static void main(String[] args) {
        GameForm game = new GameForm();
        HashMap<Integer, JButton> listButton = new HashMap<>();
        Controller control = new Controller();
        // start thread
        Thread elapse = control.initThread(game);
        elapse.start();
        // add acction button
        control.addActionButton(game, listButton, elapse);
        // create game
        control.createGame(game, listButton);
    }
}
