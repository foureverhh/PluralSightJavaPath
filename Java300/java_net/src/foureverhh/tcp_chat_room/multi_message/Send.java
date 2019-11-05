package foureverhh.tcp_chat_room.multi_message;

import foureverhh.tcp_chat_room.utils.Release;

import java.io.*;
import java.net.Socket;

public class Send implements Runnable {
    private Socket client;
    private DataOutputStream dos;
    private BufferedReader reader;
    private boolean flag;

    public Send(Socket client) {
        this.client = client;
        flag = true;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            System.out.println("Client sending build up went wrong");
            flag =false;
            Release.close(dos,this.client);
        }
    }

    @Override
    public void run() {
        while (flag){
            send();
        }
        Release.close(dos,client);
    }

    public void send(){
        try {
            String msg = reader.readLine();
            dos.writeUTF(msg);
            dos.flush();
            if(msg.equals("bye"))
                flag = false;
        } catch (IOException e) {
            System.out.println("Client sending went wrong");
        }
    }
}
