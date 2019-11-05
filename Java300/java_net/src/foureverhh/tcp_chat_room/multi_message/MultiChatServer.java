package foureverhh.tcp_chat_room.multi_message;

import foureverhh.tcp_chat_room.utils.Release;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiChatServer {
    public static void main(String[] args) throws IOException {
        System.out.println("------Server-------");
        ServerSocket server = new ServerSocket(8895);
        while(true) {
                Socket client = server.accept();
                System.out.println("One clint built");
                new Thread(new Channel(client)).start();
        }
    }


    static class Channel implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning;

        public Channel(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                isRunning = true;
            } catch (IOException e) {
                System.out.println("Exception happens!");
                release();
            }
        }

        //接收消息
        private String receive(){
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                System.out.println("Receive get exception");
                release();
            }
            return msg;
        }
        //发送消息
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                System.out.println("Send get exception");
                release();
            }
        }
        //释放资源
        private void release(){
            this.isRunning = false;
            Release.close(dis,dos,client);
        }

        @Override
        public void run() {
            while (isRunning){
                String msg = receive();
                if(!msg.equals(""))
                    send(msg);
            }
            System.out.println("one client shut down");
        }
    }


   /* static class Channel implements Runnable{
        private Socket client;
        private DataInputStream dis;
        private DataOutputStream dos;
        private String inputMsg = "";

        public Channel(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                serverIsRunning = false;
            }
        }

        @Override
        public void run() {
            try {
                inputMsg = dis.readUTF();
            System.out.println("Client Message: " + inputMsg);
            //Send response to client
                dos.writeUTF(inputMsg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(dos!=null)
                    dos.close();
                if(dis!=null)
                    dis.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
}
