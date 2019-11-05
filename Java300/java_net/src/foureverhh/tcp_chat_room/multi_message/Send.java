package foureverhh.tcp_chat_room.multi_message;

import foureverhh.tcp_chat_room.utils.Release;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Send implements Runnable {
    private String senderName;
    private Socket client;
    private DataOutputStream dos;
    private BufferedReader reader;
    private boolean flag;
    private String name;

    public Send(Socket client,String name) {
        this.name = name;
        this.client = client;
        flag = true;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            dos = new DataOutputStream(client.getOutputStream());
            send(name);
        } catch (IOException e) {
            System.out.println("Client sending build up went wrong");
            flag =false;
            Release.close(dos,this.client);
        }
    }

    @Override
    public void run() {
        while (flag){
            String msg = null;
            try {
                msg = reader.readLine();
                send(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Release.close(dos,client);
    }

    public void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
            if(msg.equals("bye"))
                flag = false;
        } catch (IOException e) {
            System.out.println("Client sending went wrong");
        }
    }
}
