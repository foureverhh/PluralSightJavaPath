package foureverhh.tcp.tcp_connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.jar.JarOutputStream;

public class Server {
    public static void main(String[] args) throws IOException {
        //Set up server
        ServerSocket server = new ServerSocket(9999);
        //Server listen to a client socket, by calling accept()
        //Blocking
        Socket client = server.accept();
        System.out.println("One client connection has been built up.");
        //Manipulation of I/O
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String data = dis.readUTF();
        System.out.println(data);
        dis.close();
        client.close();
    }
}
