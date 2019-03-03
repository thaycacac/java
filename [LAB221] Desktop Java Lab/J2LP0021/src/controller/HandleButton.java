package controller;

import form.GameForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Thaycacac
 */
public class HandleButton {

    // handle when user click one button
    public void addActionButton(HashMap<Integer, JButton> listButton, GameForm game, JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String text = button.getText();
                if (swappAble(text, listButton, game)) {
                    // process swap button click and button empty
                    swap(text, listButton, game);
                    // update count
                    updateMoveCount(game);
                    // check user win or not
                    checkWin(listButton, game);
                }
            }
        });
    }

    // process swap button click and button empty
    private void swap(String text, HashMap<Integer, JButton> listButton, GameForm game) {
        int positionCurrent = game.getPositionCurrent();
        int positionEmpty = game.getPositionEmpty();
        String textCurrent = listButton.get(positionCurrent).getText();
        listButton.get(positionEmpty).setText(textCurrent);
        listButton.get(positionCurrent).setText("");
        game.setPositionEmpty(positionCurrent);
    }

    // update count move
    private void updateMoveCount(GameForm game) {
        int countCurrent = game.getCount();
        game.setCount(++countCurrent);
        game.getTxtCount().setText(String.valueOf(countCurrent));
    }

    // check user win or not to show result
    public void checkWin(HashMap<Integer, JButton> listButton, GameForm game) {
        if (isWin(listButton)) {
            JOptionPane.showMessageDialog(game, "You Win!!!", "Congratulate", 1);
            game.setFlag(false);
            game.setTime(0);
            removeActionButton(listButton);
        }
    }

    // check user win or not
    public boolean isWin(HashMap<Integer, JButton> listButton) {
        for (Map.Entry<Integer, JButton> entry : listButton.entrySet()) {
            Integer key = entry.getKey() + 1;
            JButton value = entry.getValue();
            String text = value.getText();
            if (!text.equals("")) {
                int num = Integer.parseInt(text);
                if (num != key) {
                    return false;
                }
            }
        }
        return true;
    }

    // remove all action when win
    public void removeActionButton(HashMap<Integer, JButton> listButton) {
        for (Map.Entry<Integer, JButton> entry : listButton.entrySet()) {
            JButton value = entry.getValue();
            for (ActionListener e : value.getActionListeners()) {
                value.removeActionListener(e);
            }
        }
    }

    // check when possition user click can swap or not
    private boolean swappAble(String text, HashMap<Integer, JButton> listButton, GameForm game) {
        return isTop(text, listButton, game) || isBottom(text, listButton, game)
                || isLeft(text, listButton, game) || isRight(text, listButton, game);
    }

    // check button click is top button empty
    public boolean isTop(String text, HashMap<Integer, JButton> listButton, GameForm game) {
        int positionEmpty = game.getPositionEmpty();
        int size = game.getSizeGame();
        int positionCurrentCheck = positionEmpty + size;
        if (positionCurrentCheck < size * size && listButton.get(positionCurrentCheck).getText().equals(text)) {
            game.setPositionCurrent(positionCurrentCheck);
            return true;
        }
        return false;
    }

    // check button click is button empty
    public boolean isBottom(String text, HashMap<Integer, JButton> listButton, GameForm game) {
        int positionEmpty = game.getPositionEmpty();
        int size = game.getSizeGame();
        int positionCurrentCheck = positionEmpty - size;
        if (positionCurrentCheck < size * size
                && positionCurrentCheck >= 0
                && listButton.get(positionCurrentCheck).getText().equals(text)) {
            game.setPositionCurrent(positionCurrentCheck);
            return true;
        }
        return false;
    }

    //check button click is button right
    public boolean isRight(String text, HashMap<Integer, JButton> listButton, GameForm game) {
        int positionEmpty = game.getPositionEmpty();
        int size = game.getSizeGame();
        int positionCurrentCheck = positionEmpty + 1;
        if (positionCurrentCheck < size * size
                && positionCurrentCheck >= 0
                && listButton.get(positionCurrentCheck).getText().equals(text)) {
            game.setPositionCurrent(positionCurrentCheck);
            return true;
        }
        return false;
    }

    //check button click is button right
    public boolean isLeft(String text, HashMap<Integer, JButton> listButton, GameForm game) {
        int positionEmpty = game.getPositionEmpty();
        int size = game.getSizeGame();
        int positionCurrentCheck = positionEmpty - 1;
        if (positionCurrentCheck < size * size
                && positionCurrentCheck >= 0
                && listButton.get(positionCurrentCheck).getText().equals(text)) {
            game.setPositionCurrent(positionCurrentCheck);
            return true;
        }
        return false;
    }
}
