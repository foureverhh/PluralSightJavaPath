package foureverhh.chat_room.multi_message;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

//246
public class MulitChatClient {
    public static void main(String[] args) throws Exception {
        System.out.println("--------Client--------");
        boolean clientIsRunning = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Socket client = new Socket("localhost",8895);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream writer = new DataInputStream(client.getInputStream());
        //Client send request
        while (clientIsRunning) {
            System.out.println("Send your message: ");
            String msg = "";
            msg = reader.readLine();
            dos.writeUTF(msg);
            dos.flush();

            //Client read response
            String info = writer.readUTF();
            System.out.println("Server: " + info);
        }
        writer.close();
        dos.close();
    }


}
