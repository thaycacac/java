package button;

import game_server.GamePlayManager;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JLabel;

public class ButtonEvent implements MouseListener {

    private final GamePlayManager gameControl;

    public ButtonEvent(GamePlayManager gameControl) {
        this.gameControl = gameControl;
    }

    private void drawText(JLabel btn) {
        btn.setFont(GamePlayManager.FONT_DISPLAY);
        btn.setText(" " + gameControl.getTeam());
        Color color = (gameControl.getTeam().equals("O")) ? Color.RED : Color.BLUE;
        btn.setForeground(color);
        String nextTurn = (gameControl.getTeam().equals("O")) ? "X" : "O";
        gameControl.setTextTurn("Turn: " + nextTurn);
    }

    @Override
    public void mousePressed(MouseEvent me) {
        JLabel btn = (JLabel) me.getSource();
        String index = btn.getText();
        System.out.println("ec " + index);
        // check if button is not cliced
        if (!index.matches(" X| O")) {
            // check is your turn
            if (gameControl.isYourTurn()) {
                gameControl.setYourTurn(false);
                drawText(btn);
                gameControl.sendData("click|" + index + "|" + gameControl.getRoomID() + "|" + gameControl.getFriend());
                gameControl.getListButton().get(Integer.parseInt(index)).setStatus(gameControl.getTeam());
                return;
            }
            gameControl.displayMessage("Not your turn!");
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
