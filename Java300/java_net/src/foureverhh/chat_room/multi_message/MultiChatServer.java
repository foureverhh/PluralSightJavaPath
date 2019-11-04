package foureverhh.chat_room.multi_message;

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
                new Thread(()->{
                   DataInputStream dis = null;
                   DataOutputStream dos = null;
                   try{
                       dis = new DataInputStream(client.getInputStream());
                       dos = new DataOutputStream(client.getOutputStream());

                   } catch (IOException e) {
                       e.printStackTrace();
                   }
                   boolean serverIsRunning = true;
                   while (serverIsRunning){
                       String msg;
                       try {
                           msg = dis.readUTF();
                           dos.writeUTF(msg);
                           dos.flush();
                       } catch (IOException e) {
                           e.printStackTrace();
                           serverIsRunning=false;
                       }
                   }
                   if(dos==null){
                       try {
                           dos.close();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
                   if(dis == null){
                       try {
                           dis.close();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
                   if(client == null){
                       try {
                           client.close();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }

                }).start();
           /* while (serverIsRunning) {
                new Thread(new Channel(client)).start();
            }*/
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
