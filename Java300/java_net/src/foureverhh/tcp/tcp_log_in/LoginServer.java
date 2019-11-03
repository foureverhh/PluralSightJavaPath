package foureverhh.tcp.tcp_log_in;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//243
public class LoginServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9998);
        Socket client = server.accept();
        System.out.println("Server 9998 set up");
        //I/O
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        String msg = dis.readUTF();
        String[] info = msg.split("&");
        String username = "";
        String pwd = "";
        for(String str : info){
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)=='='){
                    if(str.substring(0,i).equals("userName")){
                        username = str.substring(i+1);
                    }else if(str.substring(0,i).equals("pwd")){
                        pwd = str.substring(i+1);
                    }
                }
            }
        }
        if(username.equals("han") && pwd.equals("1234")){
            dos.writeUTF("You are log in");
        }else {
            dos.writeUTF("You are failed to log in!");
        }
        dos.flush();
        dis.close();

    }
}
