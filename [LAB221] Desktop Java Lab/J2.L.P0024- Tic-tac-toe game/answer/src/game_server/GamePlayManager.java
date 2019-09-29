package game_server;

import button.*;
import game_client.ClientManager;
import game_client.DataTransfer;
import game_ui.GamePlayUI;
import java.awt.*;
import java.util.HashMap;
import javax.swing.JLabel;
import main_pack.Request;

public final class GamePlayManager {

    private final ClientManager clientControl;
    private final DataTransfer conn;
    private final String roomID;
    private final String userName;
    private final String friend;
    private String team;
    private final int gameSize;
    private final GamePlayUI gameUI;
    private final int limit;
    private final HashMap<Integer, MyButton> listButton;
    private boolean yourTurn;
    public static final Font FONT_DISPLAY = new Font("Tahoma", Font.BOLD, 22);

    public GamePlayManager(String roomID, String userName, String friend, String team, int gameSize, DataTransfer conn, ClientManager clientControl) {
        this.conn = conn;
        this.clientControl = clientControl;
        this.roomID = roomID;
        this.userName = userName;
        this.friend = friend;
        this.team = team;
        this.gameSize = gameSize;
        this.gameUI = new GamePlayUI(this);
        this.limit = (gameSize * gameSize);
        listButton = new HashMap<>();
        gameUI.setTitle(roomID);
        gameUI.drawGameTable(gameSize, limit);
        gameUI.setVisible(true);
        yourTurn = (team.equals("O"));
    }

    /*sua o day*/
    public void isWin(String roomID) {
        clearGame(roomID);
        gameUI.displayMessage("You win");
    }

    public void draw(String roomID) {
        clearGame(roomID);
        gameUI.displayMessage("O and X win");
    }

    public void clearGame(String roomID) {
        team = (team.equals("O")) ? "X" : "O";
        yourTurn = (team.equals("O"));
        gameUI.setTxtPlayer(team + ": -Player");
        gameUI.setTextTurn("");
        gameUI.clearGameTable(limit);
        setTextTurn("Turn: " + "O");
        conn.sendData(Request.RESET_ROOMGAME + roomID + "|" + userName + "|" + team + "|" + gameSize);
    }

    public void displayMessage(String message) {
        gameUI.displayMessage(message);
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public boolean isYourTurn() {
        return yourTurn;
    }

    public void setYourTurn(boolean yourTurn) {
        this.yourTurn = yourTurn;
    }

    public void setButtonText(int index) {
        yourTurn = !yourTurn; // switch to your turn
        JLabel lbl = listButton.get(index).getButton();
        lbl.setFont(FONT_DISPLAY);
        String friendTeam = (team.equals("O")) ? "X" : "O"; // get your friend team
        listButton.get(index).setStatus(friendTeam);
        Color color = (team.equals("O")) ? Color.BLUE : Color.RED;
        lbl.setForeground(color);
        lbl.setText(" " + friendTeam);
        setTextTurn("Turn: " + team);
    }

    public void setTextTurn(String turn) {
        gameUI.setTextTurn(turn);
    }

    public void endGame(String roomID) {
        clearGame(roomID);
        gameUI.displayMessage("You lose");
    }

    public void exitGame(String otherName) {
        gameUI.dispose();
        // remove game play frame from list game play
        clientControl.getListGamePlay().remove(roomID);
    }

    public void sendData(String data) {
        conn.sendData(data);
    }

    public int getGameSize() {
        return gameSize;
    }

    public String getRoomID() {
        return roomID;
    }

    public String getUserName() {
        return userName;
    }

    public String getFriend() {
        return friend;
    }

    public String getTeam() {
        return team;
    }

    public HashMap< Integer, MyButton> getListButton() {
        return listButton;
    }

}
