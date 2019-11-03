package foureverhh.upd.udp_image;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpFileClient {
    public static void main(String[] args) throws Exception {
        System.out.println("Client started.....");
        //1.set up client UDP socket
        DatagramSocket client = new DatagramSocket(8888);
        //2.prepare data to be transferred

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream is = new FileInputStream("flower.jpeg");
        byte[] buffer = new byte[1024 * 60];
        int len = 0;
        while((len=is.read(buffer))!=-1){
            baos.write(buffer,0,len);
        }
        //byte[] data = bis.readAllBytes();
        byte[] data = baos.toByteArray();
        //3.set up DatagramPacket
        DatagramPacket packet = new DatagramPacket(data,0,data.length, InetAddress.getLocalHost(),6789);
        //4.send packet
        client.send(packet);
        //5.release resource
        client.close();
    }
}
