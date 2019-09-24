package dataStreamIO;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;

/*
* DataInputStream
*
* DataOutputStream
*
* */
public class DataDemo01  {
    public static void main(String[] args) {
        try {
            write("DataDemo01.txt");
            read("DataDemo01.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String destPath) throws IOException {
        double point = 2.5;
        long num = 100L;
        String str = "Data type";
        //Create source
        File destFile =new File(destPath);
        //Choose stream
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(destFile)));
        dos.writeDouble(point);
        dos.writeUTF("\n");
        dos.writeLong(num);
        dos.writeUTF("\n");
        dos.writeUTF(str);
        dos.flush();
        dos.close();
    }
    public static void read(String sourcePath) throws IOException {
        //Create source
        File source = new File(sourcePath);
        //create stream
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(source)));
        StringBuilder str = new StringBuilder();
        str.append(dis.readDouble());
        str.append(dis.readUTF());
        str.append(dis.readLong());
        str.append(dis.readUTF());
        str.append(dis.readUTF());
        dis.close();
        System.out.println(str.toString());
    }

}
