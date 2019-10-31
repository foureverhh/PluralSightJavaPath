package foureverhh.upd.upd_string;

import java.io.IOException;
import java.net.*;

/*发送端
* 1.使用DatagramSocket 指定端口 创建发送端
* 2.准备数据，并将数据转为字节数组byte[]
* 3.封装成DatagramPacket包裹，    ！！！！需要指定目的地
* 4.阻塞式发送包裹send(DatagramPacket p)
* 5.释放资源
* */
public class UpdClient {
    public static void main(String[] args) {
        try {
            //1.Set up DatagramSocket
            DatagramSocket socket = new DatagramSocket(8888);
            //2.Prepare data(Make sure data must be formatted to )
            String msg = "上海尚学堂";
            byte[] data = msg.getBytes();
            //3.Pack up data into DatagramPacket, should define the target address and port!
            DatagramPacket packet = new DatagramPacket(data,0,data.length,new InetSocketAddress("localhost",9999));
            //4.send
            socket.send(packet);
            System.out.println("Client has sent packet");
            //5.release resource
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
