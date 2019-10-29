package foureverhh;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
* IP protocol is to location an equipment on the internet
* */
public class IPTest {
    public static void main(String[] args) {
        //Using getLocalHost（）to create InetAddress
        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("getAddress(): "+addr.getAddress().toString());
            System.out.println("getHostAddress(): "+addr.getHostAddress());
            System.out.println("getHostName(): "+addr.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
