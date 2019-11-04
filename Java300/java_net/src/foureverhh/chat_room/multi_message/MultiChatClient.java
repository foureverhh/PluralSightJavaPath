package foureverhh.chat_room.multi_message;

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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
            client.close();
    }
}
