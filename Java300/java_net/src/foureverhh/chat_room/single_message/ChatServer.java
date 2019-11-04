package foureverhh.chat_room.single_message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8895);
        Socket client = server.accept();
        System.out.println("One clint built");
        //Get request from client
        DataInputStream reader = new DataInputStream(client.getInputStream());
        String inputMsg = reader.readUTF();
        System.out.println("Client Message: "+inputMsg);
        //Send response to client
        DataOutputStream writer = new DataOutputStream(client.getOutputStream());
        writer.writeUTF("Hi Client, get your request.");
        writer.flush();
        writer.close();
        reader.close();

    }


}
