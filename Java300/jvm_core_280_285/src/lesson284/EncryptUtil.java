package lesson284;

import java.io.*;

public class EncrypUtil {
    public static void encrypt(String scr, String dest){
      /*  FileInputStream fis = null;
        FileOutputStream fos = null;*/
        File file = new File(dest);
        try(FileInputStream fis = new FileInputStream(scr);
            FileOutputStream fos = new FileOutputStream(file)){
                //byte[] buffer = new byte[1024];
                int temp;
                while ((temp=fis.read())!=-1) {
                    fos.write(temp ^ 0xff); //取反操作
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
