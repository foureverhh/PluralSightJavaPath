package foureverhh.tcp_chat_room.multi_message;

import foureverhh.tcp_chat_room.utils.Release;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable {
    private DataInputStream dis;
    private Socket client;
    private boolean flag;

    public Receive(Socket client) {
        this.client = client;
        flag = true;
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            flag = false;
            System.out.println("Client receive conn failed");
            Release.close(dis,client);
        }
    }

    @Override
    public void run() {
        while (flag){
            receive();
        }
        Release.close(dis,client);
    }

    public void receive(){
        try {
            String msg = dis.readUTF();
            System.out.println(msg);
        } catch (IOException e) {
            flag = false;
            System.out.println("Client receive failed");
            Release.close(dis,client);
        }
    }
}
