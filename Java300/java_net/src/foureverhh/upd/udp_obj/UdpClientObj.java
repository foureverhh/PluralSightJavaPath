package foureverhh.upd.udp_obj;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpClientObj{
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket(8888);
        Person person = new Person("John","123456");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(byteArrayOutputStream));
        oos.writeObject(person);
        oos.flush();
        byte[] data = byteArrayOutputStream.toByteArray();
        DatagramPacket packet = new DatagramPacket(data,0,data.length, InetAddress.getLocalHost(),7878);
        client.send(packet);
        oos.close();
        client.close();

    }
}
