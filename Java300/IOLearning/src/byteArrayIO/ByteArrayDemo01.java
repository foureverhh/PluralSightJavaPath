package byteArrayIO;

import java.io.*;
import java.util.Arrays;

public class ByteArrayDemo01 {
    public static void main(String[] args) {
        try {
            read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read() throws IOException {
        String msg =  "操作与文件输入流操作一致";
        byte[] source = msg.getBytes();
        InputStream is = new BufferedInputStream(new ByteArrayInputStream(source));
        byte[] buffer = new byte[1024];
        String result = "";
        int load = 0;
        while(-1!=(load = is.read(buffer))){
            result= new String(buffer,0,load);
        }
        System.out.println(result);
        is.close();
    }

    public static void write() throws IOException {
        //Destination byteArray
        byte[] desByteArray;
        //Stream
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        String msg =  "操作与文件输入流操作一致";
        byte[] info = msg.getBytes();
        bos.write(info,0,info.length);
        //retrieve data
        desByteArray = bos.toByteArray();
        System.out.println(new String(desByteArray));
        bos.close();
    }
}
