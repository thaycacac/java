package controller;

import form.GameForm;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;

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
    public void addActionButton(GameForm game, HashMap<Integer, JButton> listButton, Thread elapse) {
        game.getBtnNewGame().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                elapse.suspend();
                if (game.getTime() == 0) {
                    System.out.println("confirm");
                    int result = JOptionPane.showConfirmDialog(game, "Continue?", "Confirm", 0, 0);
                    if (result == JOptionPane.YES_OPTION) {
                        game.setTime(0);
                        game.getTxtElapsed().setText("0 sec");
                        elapse.resume();
                        createGame(game, listButton);
                    } else {
                        elapse.resume();
                        return;
                    }
                }
            }
        });
        game.getCbbSize().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                elapse.suspend();
                if (game.getTime() == 0) {
                    System.out.println("confirm");
                    int result = JOptionPane.showConfirmDialog(game, "Continue?", "Confirm", 0, 0);
                    if (result == JOptionPane.YES_OPTION) {
                        int size = getSizeWhenClick(game);
                        game.setSize(size);
                        game.setTime(0);
                        game.getTxtElapsed().setText("0 sec");
                        elapse.resume();
                        createGame(game, listButton);
                    } else {
                        elapse.resume();
                        return;
                    }
                }

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
            newButton.setPreferredSize(new Dimension(30, 30));
            game.getJpnGame().add(newButton);
            listButton.put(i, newButton);
            handleButton.addActionButton(listButton, game, newButton);
        }
        game.setSize(60 * size, 60 * 2 * size / 4 + 200);
        game.setFlag(true);
        game.setVisible(true);
    }

    // get list shuffle number
    public ArrayList listShuffle(int size) {
        ArrayList<Integer> listSuffle = new ArrayList<>();
        for (int i = 1; i < size * size; i++) {
            listSuffle.add(i);
        }
        listSuffle.add(0);
        Random ran = new Random();
        for (int i = 0; i < Math.pow(size, 3); i++) {
            switch (ran.nextInt(4)) {
                case 0:
                    swapListShuffle(listSuffle, size, size);
                    break;
                case 1:
                    swapListShuffle(listSuffle, size, -size);
                    break;
                case 2:
                    swapListShuffle(listSuffle, size, 1);
                    break;
                case 3:
                    swapListShuffle(listSuffle, size, -1);
                    break;
            }
        }
        return listSuffle;
    }

    // swap list shuffle
    public ArrayList swapListShuffle(ArrayList<Integer> listShuffle, int size, int valueChange) {
        int emptyPosition = -1;
        for (Integer num : listShuffle) {
            if (num == 0) {
                emptyPosition = listShuffle.indexOf(num);
                break;
            }
        }
        int checkPosition = emptyPosition + valueChange;
        if (checkPosition >= 0 && checkPosition < size * size) {
            listShuffle.set(emptyPosition, listShuffle.get(checkPosition));
            listShuffle.set(checkPosition, 0);
        }
        return listShuffle;
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
