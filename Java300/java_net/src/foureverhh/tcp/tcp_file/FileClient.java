package foureverhh.tcp.tcp_file;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class FileClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",9997);
        InputStream is = new BufferedInputStream(new FileInputStream("flower.jpeg"));
        OutputStream os = new DataOutputStream(client.getOutputStream());
        byte[] buffer = new byte[1024*60];
        int len = 0;
        while((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        os.flush();
        os.close();
        is.close();
        client.close();

    }
}
