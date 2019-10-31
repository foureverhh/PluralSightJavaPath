package foureverhh.upd.upd_type;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UpdTypeClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket client = new DatagramSocket(8888);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(byteArrayOutputStream));
        dos.writeUTF("DataOutputStream BufferedOutputStream ByteArrayOutputStream");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.flush();
        dos.close();
        byte[] data = byteArrayOutputStream.toByteArray();
        DatagramPacket packet = new DatagramPacket(data,0,data.length, InetAddress.getLocalHost(),9966);
        client.send(packet);
        client.close();
    }
}
