/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.GameForm;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class GameController extends HandlingButton {

    final int SPACE_BUTTON = 30;
    final int SIZE_BUTTON = 50;
//    final int MARGIN_BUTTON = 10;

    // Create randomNumber in the list
    public List<Integer> randomNumber(int size) {
        ArrayList<Integer> listNumber = new ArrayList<>();
        //for loop  from 1 to size * size to add number into array list
        for (int i = 1; i <= size * size; i++) {
            listNumber.add(i);
        }
        shuffle(size, listNumber);
        return listNumber;
    }

    //shuffled numbers in the list
    public List<Integer> shuffle(int size, List<Integer> listNumber) {
        do {
            Collections.shuffle(listNumber);
        } while (!checkShuffle(size, listNumber));
        return listNumber;
    }

    // Check shuffle's Algorithm always right!
    public boolean checkShuffle(int size, List<Integer> listNumber) {
        // count lo so phan tu lon hon phan tu thu i
        // 1 2 3 | 4 5 6 | 7 8 
        int count = 0;
        int posiEmty = 0;
        int max = listNumber.size();

        for (int i = 0; i < max; i++) {
            // danh dau empty position
            if (listNumber.get(i) == max) {
                posiEmty = i;
                continue;
            }
            // dem so phan tu lon hon phan tu thu i trong lít number
            for (int j = i + 1; j < max; j++) {
                // check max thi ko dem
                if (listNumber.get(j) == max) {
                    continue;
                }
                // check so thu i lon hon j thi count + 1
                if (listNumber.get(i) > listNumber.get(j)) {
                    count++;
                }
            }
        }

        System.out.println("Count: " + count + " Size: " + size + " PosiEmpty: " + posiEmty);
        // if size le thi count % 2 la dung 
        if (size % 2 == 1) {
            return count % 2 == 0;
        } else {
            // if size chan thi ung voi dong chan la count chan dong le count le
            return ((posiEmty / size + 1) % 2 == 0 && count % 2 == 0)
                    || ((posiEmty / size + 1) % 2 == 1 && count % 2 == 1);
        }
    }

    // create Game's Area
    public void createGameArea(HashMap<Integer, JButton> listButton, GameForm game) {
        int size = game.getEdge();
        ArrayList<Integer> listNumber = (ArrayList) randomNumber(size);
        game.getPnlAreaGame().removeAll();
        game.getPnlAreaGame().setLayout(new GridLayout(size, size, SPACE_BUTTON, SPACE_BUTTON));
//        game.getPnlAreaGame().setSize(size, size);
        //loop for
        for (int i = 0; i < size * size; i++) {
            int num = listNumber.get(i);
            String txt = num % (size * size) != 0 ? num + "" : "";
            if (txt.equals("")) {
                game.setEmptyPosi(i);
            }
            JButton btn = new JButton(txt);
            btn.setPreferredSize(new Dimension(SIZE_BUTTON, SIZE_BUTTON));
//            btn.setMargin(new Insets(MARGIN_BUTTON, MARGIN_BUTTON, MARGIN_BUTTON, MARGIN_BUTTON));
            addButtonAction(btn, listButton, game);
            listButton.put(i, btn);
            game.getPnlAreaGame().add(btn);
        }
        game.pack();
    }

    // Set size game area
    public void setSizeGameArea(GameForm game) {
        String sizeString = game.getCmbSize().getSelectedItem().toString();
        String[] sizeSquare = sizeString.split("x");
        try {
            int num = Integer.parseInt(sizeSquare[0]);
            game.setEdge(num);
        } catch (NumberFormatException nfe) {
            System.err.println("Size illegal");
        }
    }

    // Add action for btnNewGame and CmbSize
    public void addAction(HashMap<Integer, JButton> listButton, GameForm game) {
        game.getBtnNewGame().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (game.isFlag()) {
                    game.setFlag(false);
                    int confirm = JOptionPane.showConfirmDialog(game, "Do you really want to start new game?",
                            "Confirm Dialog", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        game.setFlag(true);
                        game.setTime(0);
                        game.getLbTime().setText(game.getTime() + " sec");
                        game.setMoveCount(0);
                        game.getLbCount().setText(Integer.toString(game.getMoveCount()));
                        createGameArea(listButton, game);
                    } else {
                        game.setFlag(true);
                        
                    }
                } else {
                    game.setFlag(true);
                    game.setTime(0);
                    game.getLbTime().setText(game.getTime() + " sec");
                    game.setMoveCount(0);
                    game.getLbCount().setText(Integer.toString(game.getMoveCount()));
                    createGameArea(listButton, game);
                }

            }
        });
        game.getCmbSize().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSizeGameArea(game);
            }
        });
    }

    // Thread for time count
    public Thread ThreadElapse(GameForm game) {
        Thread elapsed = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (game.isFlag()) {
                        int time = game.getTime();
                        game.getLbTime().setText(++time + " sec");
                        game.setTime(time);
                    }
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        System.err.println("Thread elapse error");
                    }
                }
            }
        };
        return elapsed;
    }
}
