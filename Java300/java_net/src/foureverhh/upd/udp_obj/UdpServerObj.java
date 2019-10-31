package foureverhh.upd.udp_obj;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServerObj {
    public static void main(String[] args) throws Exception {
        DatagramSocket server = new DatagramSocket(7878);
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        server.receive(packet);
        server.close();

        byte[] dataReceived = packet.getData();
        ByteArrayInputStream bis = new ByteArrayInputStream(dataReceived);
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(bis));
        Person p = (Person) ois.readObject();
        System.out.println(p);
        ois.close();
    }
}
