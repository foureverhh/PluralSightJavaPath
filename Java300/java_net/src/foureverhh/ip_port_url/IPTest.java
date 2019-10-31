package foureverhh.ip_port_url;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
* IP address is to locate a node in the internet
* InetAddress class
*
*1.getLocalHost()
*2.getHostByName("www.163.com");
*
* instance method
*   getHostAddress() -> return address
*   getHostName()    -> return node name
* */
public class IPTest {
    public static void main(String[] args) {
        //Using getLocalHost（）to create InetAddress
        try {
            InetAddress addr = InetAddress.getLocalHost();
            //System.out.println("getAddress(): "+addr.getAddress().toString());
            System.out.println("getHostAddress(): "+addr.getHostAddress());
            System.out.println("getHostName(): "+addr.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        //Get InetAddress by DNS name
        try {
            InetAddress netEase = InetAddress.getByName("www.163.com");
            System.out.println("getHostAddress(): "+netEase.getHostAddress());
            System.out.println("getHostName(): "+netEase.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
