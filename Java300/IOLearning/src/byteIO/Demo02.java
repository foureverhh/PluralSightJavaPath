package byteIO;

import java.io.*;

public class Demo02 {
    public static void main(String[] args) {
        File file = new File("data.txt");
        OutputStream os =null;
        try {
            os = new FileOutputStream(file,true);
            String str = "\n\rAppend it";
            //字符串转字节数组
            byte[] data = str.getBytes();
            os.write(data,0,data.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件未找到！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件写出失败");
        }finally {
            if(null!= os){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭输出流失败");
                }
            }
        }
    }
}
