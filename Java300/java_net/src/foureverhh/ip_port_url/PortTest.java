package foureverhh.ip_port_url;

import java.net.InetSocketAddress;

public class PortTest {
    public static void main(String[] args) {
        InetSocketAddress socketAddress1 = new InetSocketAddress("163.171.141.114",8080);
        InetSocketAddress socketAddress2 = new InetSocketAddress("localhost",9000);
        System.out.println(socketAddress1.getAddress());
        System.out.println(socketAddress2.getHostName());
        System.out.println(socketAddress1.getPort());
        System.out.println(socketAddress2.getPort());
    }


}
