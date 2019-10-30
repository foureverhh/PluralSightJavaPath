package foureverhh;

import java.net.MalformedURLException;
import java.net.URL;

/*
* 统一互联网三大基石： URL HTML HTTP
* URL universal Resource Locator
* protocol host(or localhost) port path parameter anchor
*
* */
public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.baidu.com:80//index.html?uname=user&pwd=0#a");
        System.out.println("Protocol: "+url.getProtocol());
        System.out.println("Host: "+url.getHost());
        System.out.println("Port: "+url.getPort());
        System.out.println("File: "+url.getFile());
        //Get URI getFile
        System.out.println("Path: "+url.getPath());
        //Get parameters -> getQuery()
        System.out.println("Query:"+url.getQuery());
        //Get anchor -> getRef()
        System.out.println("Ref: "+url.getRef());
    }
}
