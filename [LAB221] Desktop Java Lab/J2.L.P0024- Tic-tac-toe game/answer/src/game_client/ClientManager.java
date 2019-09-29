package game_client;

import game_server.GamePlayManager;
import game_ui.LoginUI;
import game_ui.HomeUI;
import java.util.*;
import main_pack.Request;

public class ClientManager {

    private final DataTransfer conn;
    private final LoginUI loginUI;
    private final HomeUI homeUI;
    private String userName;
    private int size;
    private final HashMap<String, GamePlayManager> listGamePlay;
    private final HashSet<String> listOnline;
    private final HashSet<String> listInvite;
    private String roomID;
    private String team;

    public ClientManager() {
        conn = new DataTransfer(this);
        loginUI = new LoginUI(this);
        homeUI = new HomeUI(this);
        listOnline = new HashSet<>();
        listGamePlay = new HashMap<>();
        listInvite = new HashSet<>();
        loginUI.setVisible(true);
    }

    //khởi tạo rom id
    private String generatorRoomID() {
        // room id format -> R_ID: + current time + random number with 6 digits
        Calendar cal = Calendar.getInstance();
        String raw = "R_ID:" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND);
        return raw + "-" + new Random().nextInt(9999999);
    }

    //random x o
    private String generatorTeam() {
        return (new Random().nextBoolean()) ? "O" : "X";
    }

    //
    public void loseGame(String data) {
        //roomID|friend
        StringTokenizer tk = new StringTokenizer(data, "|");
        String r_ID = tk.nextToken();
        String name = tk.nextToken();
        if (name.equals(userName)) {
            listGamePlay.get(r_ID).endGame(r_ID);
        }
    }

    public void winGame(String data) {
        //roomID|friend
        StringTokenizer tk = new StringTokenizer(data, "|");
        String r_ID = tk.nextToken();
        String name = tk.nextToken();
        if (name.equals(userName)) {
            listGamePlay.get(r_ID).isWin(r_ID);
        }
    }

    public void getInvite(String data) {
        // send-invite|sender|received|size|roomID|team
        StringTokenizer tk = new StringTokenizer(data, "|");
        String request = tk.nextToken();
        String from = tk.nextToken();
        String to = tk.nextToken();
        size = Integer.parseInt(tk.nextToken());
        String currentRoomID = tk.nextToken();
        String currentTeam = (tk.nextToken().equals("O")) ? "X" : "O";
        // 
        if (homeUI.getUserChoice(from, size) == 0) {// if client accected invite
            conn.sendData(Request.REPLY_INVITE_YES + to + "|" + from);
            GamePlayManager gamePlay = new GamePlayManager(currentRoomID, userName, from, currentTeam, size, conn, this);
            listGamePlay.put(currentRoomID, gamePlay);
        } else { // not accteced invite
            conn.sendData(Request.REPLY_INVITE_NO + to + "|" + from);
        }
    }

    public void getRespondInvite(String data) {
        //reply-invite|NO|"+to+"|"+from
        StringTokenizer tk = new StringTokenizer(data, "|");
        String rq = tk.nextToken();
        String ans = tk.nextToken();
        String from = tk.nextToken();
        //
        if (ans.equals("NO")) {// received not accected send invite
            homeUI.displayMessage("Reject your invite");
            listInvite.remove(from);
            return;
        }
        //sua o day
        GamePlayManager gamePlay = new GamePlayManager(roomID, userName, from, team, size, conn, this);
        listGamePlay.put(roomID, gamePlay);
        conn.sendData(Request.CREATE_ROOM + roomID + "|" + userName + "|" + from + "|" + team + "|" + size);
        listInvite.remove(from);
    }

    public void sendInvite(String sendTo) {
        if (!listInvite.contains(sendTo)) {
            // send-invite|sender|received|size|roomID|team
            size = homeUI.getGameSize();
            roomID = generatorRoomID();
            team = generatorTeam();
            conn.sendData(Request.SEND_INVITE + userName + "|" + sendTo + "|" + homeUI.getGameSize() + "|" + roomID + "|" + team);
            listInvite.add(sendTo);
        } else {
            homeUI.displayMessage("You just sent invite her/him.Please wait responsive your invite!");
        }
    }

    public void setOffline() {
        conn.sendData(Request.REMOVE_OFFLINE_CLIENT + this.userName);
    }

    public String getUserName() {
        return userName;
    }

    public void addUserOnline(String userName) {
        // check if user is new or not
        if (!userName.equals(this.userName) && (!listOnline.contains(userName))) {
            homeUI.addUserToList(userName);
            listOnline.add(userName);
        }
    }

    public void removeUserOffline(String userName) {
        listOnline.remove(userName);
        homeUI.removeUserFromList(userName);
    }

    public void readyConnect(String userName) {
        // if connect is success
        if (conn.connectToServer()) {
            this.userName = userName;
            conn.sendData(Request.SET_USER_NAME + userName);
        } else { // if connect fail
            loginUI.displayMessage("Can not connect to server");
        }
    }

    public void checkUserName(String data) {
        if (data.contains(Request.CHECK_USER_INCORRECT)) {
            loginUI.displayMessage("User name is exist try input other name");
        } else {
            homeUI.setVisible(true);
            loginUI.dispose();
            homeUI.addUserToList(userName + " (online)");
        }
    }

    public HashMap<String, GamePlayManager> getListGamePlay() {
        return listGamePlay; // key is room ID
    }

    public void processClick(String data) {
        // click|index|room_ID|friend
        StringTokenizer tk = new StringTokenizer(data, "|");
        String rq = tk.nextToken();
        String index = tk.nextToken();
        String rID = tk.nextToken();
        listGamePlay.get(rID).setButtonText(Integer.parseInt(index));
    }

    public void processDraw(String data) {
        // draw|room_ID|friend
        StringTokenizer tk = new StringTokenizer(data, "|");
        String rq = tk.nextToken();
        String room_ID = tk.nextToken();
        listGamePlay.get(room_ID).draw(room_ID);
    }
    
    public void removeGameUI(String request){
        StringTokenizer tk = new StringTokenizer(request, "|");
        String rq = tk.nextToken();
        String room_ID = tk.nextToken();
        String you = tk.nextToken();
        listGamePlay.get(room_ID).exitGame(you);
    }
}
