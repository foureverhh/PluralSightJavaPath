package foureverhh.upd.concurrent_upd.talk_one_by_one;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class TalkSend implements Runnable {
    private DatagramSocket socket;
    private Scanner scanner;
    private int receiverPort;
    private BlockingQueue queue;

    public TalkSend(int port,int receiverPort) {
        try {
            socket = new DatagramSocket(port);
            scanner = new Scanner(System.in);
            this.receiverPort = receiverPort;
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public TalkSend(int port,int receiverPort,BlockingQueue queue) {
        try {
            socket = new DatagramSocket(port);
            scanner = new Scanner(System.in);
            this.receiverPort = receiverPort;
            this.queue = queue;
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            String msg = scanner.nextLine();
            byte[] data = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(data,0,data.length,new InetSocketAddress("localhost",this.receiverPort));
            try {
                socket.send(packet);
                //queue.put(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(msg.equals("bye"))
                break;
        }
        socket.close();
    }
}
