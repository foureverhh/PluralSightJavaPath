package byteArrayIO;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;

/*
* Input : File -> program -> byteArray
*
*
* Output : byteArray ->program -> File
*
*
* */
public class ByteArrayDemo02 {
    public static void main(String[] args) {
        try {
            byte[] bytes = getBytesFromFile();
            System.out.println(new String(bytes));
            writeByteArrayToFile(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static byte[] getBytesFromFile() throws IOException {
      InputStream is = new BufferedInputStream(new FileInputStream("data.txt"));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      byte[] buffer = new byte[1024];
      int load = 0;
      while(-1!=(load = is.read(buffer))){
          bos.write(buffer,0,load);
      }
      bos.flush();
      byte[] dest = bos.toByteArray();
      bos.close();
      return dest;
    }

    static void writeByteArrayToFile(byte[] bytes) throws IOException {
        File dest = new File("ByteArrayDemo02.txt");
        InputStream is = new BufferedInputStream(new ByteArrayInputStream(bytes));
        OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
        byte[] buffer = new byte[1024];
        int len = 0;
        while(-1!=(len = is.read(buffer))){
            os.write(buffer,0,len);
        }
        os.flush();
        os.close();
        is.close();
    }
}
