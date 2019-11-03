package foureverhh.upd.concurrent_upd.talk_one_by_one;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.BlockingQueue;

public class TalkReceive implements Runnable {
    private DatagramSocket socket;
    private BlockingQueue queue;
    private String sender;

    public TalkReceive(String sender,int port) {
        this.sender = sender;
        try {
            socket = new DatagramSocket(port);

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public TalkReceive(String sender,int port,BlockingQueue queue) {
        this.sender = sender;
        try {
            socket = new DatagramSocket(port);
            this.queue = queue;
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            byte[] container = new byte[1024*60];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            try {
                socket.receive(packet);
                byte[] data = packet.getData();
                String msg = new String(data,0,packet.getLength());
                System.out.println(sender+": "+msg);
                //queue.take();
                if(msg.equals("bye"))
                    break;
            } catch (IOException  e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
