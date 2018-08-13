package SocketIO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author THAYCACAC
 */
public class MyseverSocket {

    ServerSocket ss;
    Socket sc;
    DataOutputStream dos;
    DataInputStream dis;

    public static final int PORT = 4321;

    public MyseverSocket() {
        initServer();
    }

    private void initServer() {
        try {
            ss = new ServerSocket(PORT);
            sc = ss.accept();
            dos = new DataOutputStream(sc.getOutputStream());
            dis = new DataInputStream(sc.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(String s) {
        try {
            dos.writeUTF(s);
            System.out.println("Server send: " + s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void receive() {
        try {
            String s = dis.readUTF();
            System.out.println("Server receive: " + s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyseverSocket server = new MyseverSocket();
        server.send("I am server");
        server.receive();
        server.send("Hello client");
        server.receive();
    }

}
