package game_server;

import java.net.*;
import java.io.*;
import java.util.HashMap;
import main_pack.Request;

public class MainServer {

    private ServerSocket svSocket;
    private Thread accectClient;
    private static int id;
    private HashMap<String, ServerThread> listThread;
    private HashMap<String, String[][]> listRoom;
    private HashMap<String, String[]> listStatus;
    private final CheckWin checkWin = new CheckWin();

    private boolean openServer() {
        try {
            svSocket = new ServerSocket(2897);
            listThread = new HashMap<>();
            listRoom = new HashMap<>();
            listStatus = new HashMap<>();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    private void accectClient() {
        accectClient = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("Wait client...");
                        Socket socket = svSocket.accept();
                        addNewClient(socket);
                    } catch (IOException ex) {
                        System.err.println(ex);
                    }
                }
            }
        };
        accectClient.start();
    }

    private void addNewClient(Socket socket) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Accected new client...");
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ServerThread svThread = new ServerThread(socket, br, bw, "" + id, this);
            svThread.start();
            listThread.put("" + id++, svThread);
            Thread.sleep(10);
        } catch (IOException | InterruptedException ex) {
            System.err.println(ex);
        }
    }

    public HashMap<String, ServerThread> getListThread() {
        return listThread;
    }

    /*Sua o day*/
    public void addListGameRunning(String roomID, String player_1, String player_2, String team_1, int size) {
        String[] status = newStatus(size);
        String team_2 = team_1.equals("O") ? "X" : "O";
        String[][] data = {{player_1, player_2}, {team_1, team_2}};
        listRoom.put(roomID, data);
        listStatus.put(roomID, status);
    }

    public String[] newStatus(int size){
        String[] status = new String[size * size];
        for (int i = 0; i < size * size; i++) {
            status[i] = "*";
        }
        return status;
    }
    public void resetListGameRunning(String roomID, String you, String team, int size) {
        int no = listRoom.get(roomID)[0][0].equals(you) ? 0 : 1;
        listRoom.get(roomID)[1][no] = team;
        listStatus.replace(roomID, newStatus(size));
    }

    public void setStatusAtServer(String roomID, int index, String playerNext, ServerThread serThread) {
        String[] status = listStatus.get(roomID);
        String data[][] = listRoom.get(roomID);
        int noPlayer = data[0][0].equals(playerNext) ? 1 : 0;
        status[index] = data[1][noPlayer];
        listStatus.replace(roomID, status);
        String[] statuss = listStatus.get(roomID);
        for (String status1 : statuss) {
            System.out.print(status1);
        }
        
        checkWinClient(checkWin, noPlayer, index, roomID, serThread);
    }

    private void checkWinClient(CheckWin checkWin, int noPlayer, int index, String roomID, ServerThread serThread) {
        String you = listRoom.get(roomID)[0][noPlayer];
        String friend = listRoom.get(roomID)[0][noPlayer == 1 ? 0 : 1];
        System.out.println(you + " " + friend);
        String agent = listRoom.get(roomID)[1][noPlayer];
        String[] sta = listStatus.get(roomID);
        checkWin.setSizeAndStatus(sta);
        boolean win_1 = checkWin.checkColumn(index, agent); // check win by column
        boolean win_2 = checkWin.checkRow(index, agent); // check win by row
        boolean win_3 = checkWin.checkDiagonalLeft(index, agent); // check win by diagonal Left
        boolean win_4 = checkWin.checkDiagonalRight(index, agent); // check win by diagonal Right
        boolean game_draw = checkWin.checkDraw();
        if (win_1 || win_2 || win_3 || win_4) { // win
            serThread.sendTo(Request.LOSE_NOTIFY + roomID + "|" + friend, friend);
            serThread.sendData(Request.WIN_NOTIFY + roomID + "|" + you);
        } else if (game_draw) { // draw
            serThread.sendTo(Request.GAME_DRAW + roomID + "|" + friend, friend);
            serThread.sendData(Request.GAME_DRAW + roomID + "|" + you);
        }
    }

    public static void main(String[] args) {
        MainServer server = new MainServer();
        // if server open port success
        if (server.openServer()) {
            server.accectClient(); // run thread for accect new clients
        }

    }
}
