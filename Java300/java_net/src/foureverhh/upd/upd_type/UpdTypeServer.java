package foureverhh.upd.upd_type;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UpdTypeServer {
    public static void main(String[] args) throws Exception {
        //DatagramSocket Server receive datagrampacket
        DatagramSocket server = new DatagramSocket(9966);
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        server.receive(packet);


        //Handle the receive data in packet
        byte[] data = packet.getData();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(new BufferedInputStream(byteArrayInputStream));
        String str = dis.readUTF();
        int num = dis.readInt();
        boolean bool = dis.readBoolean();
        char c = dis.readChar();
        dis.close();
        server.close();
        System.out.println(str+" "+num+" "+bool+" "+c);

    }

}
