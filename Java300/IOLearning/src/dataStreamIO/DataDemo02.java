package dataStreamIO;

import java.io.*;

/*
* Data + type to byte array
*
* */
public class DataDemo02 {
    public static void main(String[] args) throws IOException {
        byte[] data = write();
        System.out.println(data.length);
        read(data);
    }

    public static byte[] write() throws IOException {
        //target byte array
        byte[] dest = null;
        double point = 2.5;
        long num = 100L;
        String str = "Data Type";

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(bos));
        dos.writeDouble(point);
        dos.writeLong(num);
        dos.writeUTF(str);

        dos.flush();
        dest = bos.toByteArray();
        bos.close();
        dos.close();
        return dest;
    }

    public static void read(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        DataInputStream dis = new DataInputStream(new BufferedInputStream(bis));
        double d = dis.readDouble();
        long l = dis.readLong();
        String str = dis.readUTF();
        System.out.println(d+" , "+l+" , "+str);

    }
}
