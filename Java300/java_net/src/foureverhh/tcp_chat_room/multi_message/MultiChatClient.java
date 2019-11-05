package foureverhh.tcp_chat_room.multi_message;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

//246
public class MultiChatClient {
    public static void main(String[] args) throws Exception {
        System.out.println("--------Client--------");
        boolean clientIsRunning = true;
        Socket client = new Socket("localhost",8895);
        //send thread
        new Thread(new Send(client)).start();
        //Receive thread
        new Thread(new Receive(client)).start();

       /* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        //Client send request
        while (clientIsRunning) {
            System.out.println("Send your message: ");

            String msg = reader.readLine();
            dos.writeUTF(msg);
            dos.flush();

            //Client read response

            String info = dis.readUTF();
            System.out.println("Server: " + info);
        }
            dis.close();
            dos.close();
            client.close();*/
    }
}
