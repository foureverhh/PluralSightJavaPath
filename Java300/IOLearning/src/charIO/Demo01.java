package charIO;

import java.io.*;

public class Demo01 {
    public static void main(String[] args) {
        String str = "abc";
        int stringLength = str.length();
        char[] chars ={'a','b','c'};
        int charLength = chars.length;

        File src = new File("data.txt");
        File tar = new File("targetChar.txt");

        Reader reader = null;
        Writer writer = null;

        {
            try {
                reader = new FileReader(src);
                writer = new FileWriter(tar);
                char[] buffer = new char[1024];
                int load = 0;
                while ((load=reader.read(buffer))!=-1){
                    writer.write(buffer,0,load);
                }
                writer.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(null!=writer) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(null!=reader){
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
