package foureverhh.tcp.tcp_multi_log_in;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//245
public class MultiLoginServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9996);
        boolean isRunning = true;
    while(isRunning) {
        Socket client = server.accept();
        System.out.println("One client set up");
        new Thread(new Channel(client)).start();
    }
    server.close();
    }

    static class Channel implements Runnable{
        private Socket client;
        private DataInputStream dis;
        private DataOutputStream dos;

        public Channel(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    client.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            try {
                String msg = receive();
                String[] info = msg.split("&");
                String username = "";
                String pwd = "";

                for (String str : info) {
                    for (int i = 0; i < str.length(); i++) {
                        if (str.charAt(i) == '=') {
                            if (str.substring(0, i).equals("userName")) {
                                username = str.substring(i + 1);
                                System.out.println("User name is: "+username);
                            } else if (str.substring(0, i).equals("pwd")) {
                                pwd = str.substring(i + 1);
                                System.out.println("password is: "+pwd);
                            }
                        }
                    }
                }
            if (username.equals("han") && pwd.equals("1234")) {
                send("You are log in");
            } else {
                send("You are failed to log in!");
            }

            dos.close();
            dis.close();
            client.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String receive(){
            String datas = "";
            try {
                datas = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  datas;
        }

        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
