package foureverhh.tcp.tcp_file;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
//244
public class FileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9997);
        Socket client = server.accept();
        InputStream is = new BufferedInputStream(client.getInputStream());
        OutputStream os = new BufferedOutputStream(new FileOutputStream("file_flower.jpeg"));
        byte[] buffer = new byte[1024*60];
        int len = 0;
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        os.flush();
        os.close();
        is.close();
    }
}
