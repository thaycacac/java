package controller;

import form.GameForm;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.swing.JButton;

/**
 *
 * @author Thaycacac
 */
public class Controller {

    // create thread
    public Thread initThread(GameForm game) {
        Thread threadTime = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // check game is playing
                        if (game.isFlag()) {
                            int timeCurrent = getTimeCurrent(game);
                            game.getTxtElapsed().setText(++timeCurrent + " sec");
                        }
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        return threadTime;
    }

    // add action button
    public void addActionButton(GameForm game, HashMap<Integer, JButton> listButton) {
        game.getBtnNewGame().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.setTime(0);
                game.getTxtElapsed().setText("0 sec");
                createGame(game, listButton);
            }
        });
        game.getCbbSize().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int size = getSizeWhenClick(game);
                game.setSize(size);
                createGame(game, listButton);
            }
        });
    }

    // add area game
    public void createGame(GameForm game, HashMap<Integer, JButton> listButton) {
        int size = game.getSizeGame();
        ArrayList<Integer> listShuffle = listShuffle(size);
        game.getJpnGame().removeAll();
        game.getJpnGame().setLayout(new GridLayout(size, size));
        HandleButton handleButton = new HandleButton();
        // loop until end array to create and set value to button
        for (int i = 0; i < size * size; i++) {
            int number = listShuffle.get(i);
            JButton newButton = new JButton();
            if (number == 0) {
                game.setPositionEmpty(i);
            }
            newButton.setText((number == 0) ? "" : String.valueOf(number));
            newButton.setPreferredSize(new Dimension(40, 40));
            game.getJpnGame().add(newButton);
            listButton.put(i, newButton);
            handleButton.addActionButton(listButton, game, newButton);
        }
        game.setFlag(true);
        game.setVisible(true);
    }

    // get list shuffle number
    public ArrayList listShuffle(int size) {
        ArrayList<Integer> listSuffle = new ArrayList<>();
        for (int i = 0; i < size * size; i++) {
            listSuffle.add(i);
        }
        Collections.shuffle(listSuffle);
        return listSuffle;
    }

    // get size when user change value
    public int getSizeWhenClick(GameForm game) {
        String[] textSize = game.getCbbSize().getSelectedItem().toString().split("");
        int size = Integer.parseInt(textSize[0]);
        return size;
    }

    // get time currentt
    public int getTimeCurrent(GameForm game) {
        String[] textEsclape = game.getTxtElapsed().getText().split(" ");
        return Integer.parseInt(textEsclape[0]);
    }
    
}
