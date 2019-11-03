package foureverhh.tcp.tcp_connection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //Set up socket
        Socket client = new Socket("localhost",9999);
        System.out.println("This is client");
        //Handle I/O stream
        //Client write out
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        String data = "hello";
        dos.writeUTF(data);
        dos.flush();
        dos.close();
        client.close();
    }
}
