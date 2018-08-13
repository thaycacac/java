package SocketIO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author THAYCACAC
 */
public class MyClient {
    
    Socket sc;
    DataOutputStream dos;
    DataInputStream dis;
    
    public MyClient() {
        initClient();
    }
    
    private void initClient() {
        try {
            sc = new Socket("127.0.0.1", MyseverSocket.PORT);
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
        MyClient client = new MyClient();
        client.receive();
        client.send("I am client");
        client.receive();
        client.send("Hello server");
    }
    
}
