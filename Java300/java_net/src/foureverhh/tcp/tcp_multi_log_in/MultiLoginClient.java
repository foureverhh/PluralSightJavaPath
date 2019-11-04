package foureverhh.tcp.tcp_multi_log_in;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
//245
public class MultiLoginClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",9996);
        //new Send(client).init();
        new Send(client).send();
     /*   DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("userName="+userName+"&pwd="+pwd);
        dos.flush();*/

 /*       DataInputStream dis = new DataInputStream(client.getInputStream());
        System.out.println(dis.readUTF());*/
        new Receive(client).receive();
    /*    dos.close();
        dis.close();*/
        client.close();
    }
    static class Send{
        private DataOutputStream dos;
        private Socket client;
        private String userName;
        private String pwd;
        public Send(Socket client) {
            init();
            this.client = client;
            try {
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void init(){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input your username");System.out.flush();
            userName = scanner.next();
            System.out.print("Input your password");System.out.flush();
            pwd = scanner.next();
        }

        public void send(){
            String msg = "userName="+userName+"&pwd="+pwd;
            try {
                dos.writeUTF(msg);
                dos.flush();
                System.out.println(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    static class Receive{
        private DataInputStream dis;
        private Socket client;
        public Receive(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void receive(){
            try {
                System.out.println(dis.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
