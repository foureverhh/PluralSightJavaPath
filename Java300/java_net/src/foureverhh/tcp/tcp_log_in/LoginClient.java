package foureverhh.tcp.tcp_log_in;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class LoginClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",9998);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your username");System.out.flush();
        String userName = scanner.next();
        System.out.print("Input your password");System.out.flush();
        String pwd = scanner.next();
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("userName="+userName+"&pwd="+pwd);
        dos.flush();

        DataInputStream dis = new DataInputStream(client.getInputStream());
        System.out.println(dis.readUTF());
        dos.close();
        dis.close();
    }
}
