package foureverhh.chat_room.multi_message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiChatServer {
    public static void main(String[] args) throws IOException {
        System.out.println("One clint built");
        ServerSocket server = new ServerSocket(8895);
        boolean serverIsRunning = true;
        Socket client = server.accept();
        DataInputStream reader = new DataInputStream(client.getInputStream());
        DataOutputStream writer = new DataOutputStream(client.getOutputStream());
        while (serverIsRunning) {
            //Get request from client
            String inputMsg = reader.readUTF();
            System.out.println("Client Message: " + inputMsg);
            //Send response to client
            writer.writeUTF(inputMsg);
            writer.flush();
        }
        writer.close();
        reader.close();
        server.close();
    }


}
