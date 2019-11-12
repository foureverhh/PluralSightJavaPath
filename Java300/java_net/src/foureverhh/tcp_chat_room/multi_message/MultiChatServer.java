package foureverhh.tcp_chat_room.multi_message;

import foureverhh.tcp_chat_room.utils.Release;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class MultiChatServer {

    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws IOException {
        System.out.println("------Server-------");
        ServerSocket server = new ServerSocket(8895);
        while(true) {
                Socket client = server.accept();
                System.out.println("One clint built");
                Channel newChannel = new Channel(client);
                all.add(newChannel);
                new Thread(newChannel).start();
        }
    }

    static class Channel implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning;
        private String username;

        public Channel(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                username = receive();
                send("Welcome "+username);
                sendOthers(username+" is online now",true);
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



        //发送群聊及私聊
        private void sendOthers(String msg,boolean sysInfo){
                //private conversation begins with @name:info
                if(msg.contains("@")) {
                    int index = msg.indexOf(':');
                    String targetName = msg.substring(1,index);
                    String info = msg.substring(index+1);
                    for(Channel channel: all){
                        if(channel.username.equals(targetName)){
                            channel.send(this.username+" send you info privately: "+info);
                            break;
                        }
                    }
                }else{
                for (Channel channel : all) {
                    if (channel != this) {
                        if (sysInfo)
                            channel.send(msg);
                        else
                            channel.send(this.username + " writes to all: " + msg);
                    }
                }
            }

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
            isRunning = false;
            send(username+" bye");
            sendOthers(username+" quit",true);
            all.remove(this);
            Release.close(dis,dos,client);
        }

        @Override
        public void run() {
            while (isRunning){
                String msg = receive();
                if(!msg.equals(""))
                    sendOthers(msg,false);
                    //send(msg);
            }
            //release();
            System.out.println("one client shut down");
        }
    }

}
