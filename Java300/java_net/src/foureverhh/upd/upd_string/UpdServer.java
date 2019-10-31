package foureverhh.upd.upd_string;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*接收端
* 1.使用DatagramSocket,指定端口，创建接收端
* 2.准备容器，封装成DatagramPacket包裹
* 3.阻塞式接收包裹receive(DatagramPacket p);
* 4.分析数据 byte[] getData() getLength
* 5.释放资源
* */
public class UpdServer {
    public static void main(String[] args) {
        try {
            System.out.println("接收方启动中......");
            //1.Set up DatagramSocket
            DatagramSocket server = new DatagramSocket(9999);
            //2.Prepare byte[] and capsulate it as DatagramPacket, container maximum 60k
            byte[] container = new byte[1024*60];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            //3.Receive packet
            server.receive(packet);
            //4.analise packet
            byte[] data = packet.getData();
            int length = packet.getLength();
            System.out.println(new String(data,0,length));
            //5.release resource
            server.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
