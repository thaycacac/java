package game_client;

import main_pack.Request;
import java.net.Socket;
import java.io.*;
import game_ui.LoginUI;

public final class DataTransfer {

    private final ClientManager playerControl;
    private BufferedReader br;
    private BufferedWriter bw;
    private Socket socket;
    private Thread getData;
    private LoginUI loginUI;
    private Thread sendOnline;

    public DataTransfer(ClientManager playerControl) {
        this.playerControl = playerControl;
    }

    public void setData(LoginUI loginUI) {
        this.loginUI = loginUI;
    }

    private void updateOnline() {
        sendOnline = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sendData(Request.CLIENT_ONLINE + playerControl.getUserName());
                        Thread.sleep(2345);
                    } catch (InterruptedException ex) {
                        //
                    }
                }
            }
        };
        sendOnline.start();
    }

    private void getDataFromServer() {
        getData = new Thread() {
            @Override
            public void run() {
                // loop run until @getData Thread is stopped
                while (true) {
                    String data;
                    try {
                        if ((data = br.readLine()) != null) {
                            if (data.contains(Request.CHECK_USER_NAME)) {
                                playerControl.checkUserName(data);
                            }
                            if (data.contains(Request.CLIENT_ONLINE)) {
                                playerControl.addUserOnline(data.replace(Request.CLIENT_ONLINE, ""));
                            }
                            if (data.contains(Request.REMOVE_OFFLINE_CLIENT)) {
                                playerControl.removeUserOffline(data.replace(Request.REMOVE_OFFLINE_CLIENT, ""));
                            }
                            if (data.contains(Request.SEND_INVITE)) {
                                playerControl.getInvite(data);
                            }
                            if (data.contains(Request.REPLY_INVITE)) {
                                playerControl.getRespondInvite(data);
                            }
                            if (data.contains(Request.SET_TEXT_CLICK)) {
                                playerControl.processClick(data);
                            }
                            if (data.contains(Request.LOSE_NOTIFY)) {
                                playerControl.loseGame(data.replace(Request.LOSE_NOTIFY, ""));
                            }
                            if (data.contains(Request.WIN_NOTIFY)) {
                                playerControl.winGame(data.replace(Request.WIN_NOTIFY, ""));
                            }
                            if(data.contains(Request.GAME_DRAW)){
                                playerControl.processDraw(data);
                            }
                        }
                        Thread.sleep(10);
                    } catch (InterruptedException | IOException ex) {
                        //
                    }
                    //

                }
            }
        };
        getData.start();
    }

    public boolean connectToServer() {
        try {
            socket = new Socket("localhost", 2897);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            getDataFromServer();
            updateOnline();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public void sendData(String data) {
        try {
            bw.write(data);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            // closed
        }
    }

}
