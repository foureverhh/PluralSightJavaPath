package byteIO;

import java.io.*;

public class Demo03 {
    public static void main(String[] args) {
        File source = new File("data.txt");
        File target = new File("target.txt");
        try(InputStream is = new FileInputStream(source);
            OutputStream os = new FileOutputStream(target,true)){
            byte[] buffer = new byte[1024];
            int load = 0;
            while(-1!=(load=is.read(buffer))){
                os.write(buffer,0,load);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
