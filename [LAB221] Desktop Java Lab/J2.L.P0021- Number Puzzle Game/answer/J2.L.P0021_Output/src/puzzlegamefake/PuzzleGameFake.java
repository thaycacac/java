/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlegamefake;

import Controller.GameController;
import Controller.HandlingButton;
import GUI.GameForm;
import java.util.HashMap;
import javax.swing.JButton;

/**
 *
 * @author HP
 */
public class PuzzleGameFake {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameForm game = new GameForm();
        game.setVisible(true);
        HashMap<Integer, JButton> listButton = new HashMap<>();
        GameController control = new GameController();
        Thread elapse = control.ThreadElapse(game);
        elapse.start();
        control.addAction(listButton, game);
        control.createGameArea(listButton, game);
        HandlingButton handle = new HandlingButton();
        handle.removeButtonAction(listButton);
    }

}
