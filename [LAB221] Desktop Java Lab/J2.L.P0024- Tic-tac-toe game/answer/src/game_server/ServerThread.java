package game_server;

import main_pack.Request;
import java.net.Socket;
import java.io.*;
import java.util.StringTokenizer;

public class ServerThread extends Thread {

    private final Socket socket;
    private final MainServer server;
    private final BufferedReader br;
    private final BufferedWriter bw;
    private final String threadID;

    public ServerThread(Socket s, BufferedReader br, BufferedWriter bw, String threadID, MainServer server) {
        this.socket = s;
        this.br = br;
        this.bw = bw;
        this.threadID = threadID;
        this.server = server;
    }

    public String getUserName() {
        return threadID;
    }

    private void setThreadKey(String request) {
        String usr = request.replace(Request.SET_USER_NAME, "");
        if (server.getListThread().containsKey(usr)) {
            sendData(Request.CHECK_USER_INCORRECT);
        } else {
            sendData(Request.CHECK_USER_CORRECT);
            server.getListThread().remove(threadID); // remove old thread
            server.getListThread().put(usr, this); // put new thread
        }
    }

    // send to one thread with name
    protected void sendTo(String data, String to) {
        server.getListThread().get(to).sendData(data);
    }

    private void sendAllClient(String data) {
        // loop will scan all elements of listClient
        server.getListThread().values().forEach((x) -> {
            x.sendData(data);
        });
    }

    // send to this thread
    public void sendData(String data) {
        try {
            bw.write(data);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            //
        }
    }

    private void setOffline(String userName) {
        sendAllClient(Request.REMOVE_OFFLINE_CLIENT + userName); // send offline user name to all
        server.getListThread().remove(userName);
    }

    public void sendInviteTo(String request) {
        // send-invite|sender|received|size|roomID|team
        StringTokenizer tk = new StringTokenizer(request, "|");
        String rq = tk.nextToken();
        String from = tk.nextToken();
        String to = tk.nextToken();
        sendTo(request, to);
    }

    public void processReplyInvite(String request) {
        //reply-invite|NO|"+to+"|"+from
        String received = request.substring(request.lastIndexOf("|") + 1);
        sendTo(request, received);
    }

    //sua o day
    public void createRoom(String request) {
        //Request.CREATE_ROOM + roomID + "|" + userName + "|" + from + "|" + team + "|" + size
        StringTokenizer tk = new StringTokenizer(request, "|");
        String rq = tk.nextToken();
        String romID = tk.nextToken();
        String you = tk.nextToken();
        String friend = tk.nextToken();
        String team = tk.nextToken();
        int size = Integer.parseInt(tk.nextToken());
        server.addListGameRunning(romID, you, friend, team, size);
    }
    
    public void resetRoom(String request) {
        //Request.RESET_ROOMGAME + roomID + "|" + userName + "|" + team);
        StringTokenizer tk = new StringTokenizer(request, "|");
        String rq = tk.nextToken();
        String romID = tk.nextToken();
        String you = tk.nextToken();
        String team = tk.nextToken();
        int size = Integer.parseInt(tk.nextToken());
        server.resetListGameRunning(romID, you, team, size);
    }

    public void processStatus(String request) {
        //"click|" + index + "|" + gameControl.getRoomID() + "|" + gameControl.getFriend()
        StringTokenizer tk = new StringTokenizer(request, "|");
        String rq = tk.nextToken();
        int index = Integer.parseInt(tk.nextToken());
        String roomID = tk.nextToken();
        String friend = tk.nextToken();
        sendTo(request, friend);
        server.setStatusAtServer(roomID, index, friend, this);
    }

    @Override
    public void run() {
        // loop run until thread is stopped
        while (true) {
            String request;
            try {
                if ((request = br.readLine()) != null) {
                    // update new key for each thread
                    if (request.contains(Request.SET_USER_NAME)) {
                        setThreadKey(request);
                    }
                    // send client name online to all client
                    if (request.contains(Request.CLIENT_ONLINE)) {
                        sendAllClient(request);
                    }
                    // set client offline
                    if (request.contains(Request.REMOVE_OFFLINE_CLIENT)) {
                        setOffline(request.replace(Request.REMOVE_OFFLINE_CLIENT, ""));
                    }
                    // send invite 
                    if (request.contains(Request.SEND_INVITE)) {
                        sendInviteTo(request);
                    }
                    // send reply invite
                    if (request.contains(Request.REPLY_INVITE)) {
                        processReplyInvite(request);
                    }
                    //sua o day
                    if (request.contains(Request.CREATE_ROOM)) {
                        createRoom(request);
                    }
                    // click when play game
                    if (request.contains(Request.SET_TEXT_CLICK)) {
                        processStatus(request);
                    }
                    //sua o day
                    if (request.contains(Request.RESET_ROOMGAME)) {
                        resetRoom(request);
                    }
                    if (request.contains(Request.GAME_DRAW)) {
                        sendTo(request, request.substring(request.lastIndexOf("|") + 1));
                    }
                }
                Thread.sleep(10);
            } catch (InterruptedException | IOException ex) {
                //
            }
        }
    }

}
