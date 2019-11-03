package foureverhh.concurrent_upd;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpTalkServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket server = new DatagramSocket(8848);
        while (true) {
            byte[] container = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            server.receive(packet);
            byte[] data = packet.getData();
            String msg = new String(data, 0, packet.getLength());
            System.out.println("Server receive: " + msg);
            if(msg.equals("bye"))
                break;
        }
        server.close();
    }
   /* private DatagramSocket socket;
    private Thread sendMessage;
    private Thread getMessage;

    public UdpTalkServer() {

        getMessage();
        sendMessage();
    }

    synchronized void sendMessage(){
        sendMessage = new Thread(()-> {
            System.out.println("Client, input something to send");
            Scanner sc = new Scanner(System.in);
            String msg = sc.next();
            if (!msg.isEmpty()) {
                byte[] data = msg.getBytes();
                try {
                    DatagramPacket packet = new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(), 8880);
                    socket.send(packet);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    synchronized void getMessage(){
        getMessage = new Thread(()-> {
            byte[] container = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            try {
                socket = new DatagramSocket(8848);
                socket.receive(packet);
                byte[] data = packet.getData();
                System.out.println("Message from Client: " + new String(data, 0, packet.getLength()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
*/
}
