package foureverhh.upd.concurrent_upd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class UdpTalkClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket client = new DatagramSocket(8880);
        while(true) {
            System.out.println("Client write something to Server:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            byte[] data = input.getBytes();
            DatagramPacket packet = new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(), 8848);
            client.send(packet);
            if(input.equals("bye"))
                break;
            }
        client.close();
    }
/*

    private DatagramSocket socket;
    private Thread sendMessage;
    private Thread getMessage;

    public UdpTalkClient() {
        getMessage();
        sendMessage();
    }

    synchronized void sendMessage(){
        sendMessage = new Thread(()->{
            System.out.println("Server, input something to send");
            Scanner sc = new Scanner(System.in);
            String msg = sc.next();
            if (!msg.isEmpty()) {
                byte[] data = msg.getBytes();
                try {
                    socket = new DatagramSocket(8880);
                    DatagramPacket packet = new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(), 8848);
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
                socket.receive(packet);
                byte[] data = packet.getData();
                System.out.println("Message from Server: " + new String(data, 0, packet.getLength()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
*/

}
