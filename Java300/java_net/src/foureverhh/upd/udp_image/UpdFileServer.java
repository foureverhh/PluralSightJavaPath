package foureverhh.upd.udp_image;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UpdFileServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        //1.Set up server socket
        DatagramSocket server = new DatagramSocket(6789);
        //2.set up container and packet for server side
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        //3.receive packet from client
        server.receive(packet);
        //4. handle the received packet
        byte[] data = packet.getData();
        BufferedOutputStream bis = new BufferedOutputStream(new FileOutputStream(new File("receivedFlower.jpeg")));
        bis.write(data,0,packet.getLength());
        bis.flush();
        bis.close();
        server.close();

    }
}
