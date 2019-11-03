package foureverhh.tcp.tcp_log_in;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9998);
        Socket client = server.accept();
        System.out.println("Server 9998 set up");
        //I/O
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg = dis.readUTF();
        String[] info = msg.split("&");
        for(String str : info){
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)=='='){
                    str = str.substring(i+1);
                    System.out.println(str);
                }
            }
        }
        dis.close();

    }
}
