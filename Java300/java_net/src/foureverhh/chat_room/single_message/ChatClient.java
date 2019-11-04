package foureverhh.chat_room.single_message;

import java.io.*;
import java.net.Socket;
//246
public class ChatClient {
    public static void main(String[] args) throws Exception {
        System.out.println("--------Client--------");
        Socket client = new Socket("localhost",8895);
        //Client send request
        String msg = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        msg = reader.readLine();
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(msg);
        dos.flush();

        //Client read response
        DataInputStream writer = new DataInputStream(client.getInputStream());
        String info = writer.readUTF();
        System.out.println("Server: "+info);
    }


}
