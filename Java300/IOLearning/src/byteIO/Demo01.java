package byteIO;

import java.io.*;

public class Demo01 {
    public static void main(String[] args) {
        //Set up file object
        File scr = new File("data.txt");
        //Choose right stream
        InputStream is = null;//Promote variable from local variable to global variable
        try {
            is = new FileInputStream(scr);
            //read byte[]
            byte[] interMedia = new byte[10];//缓冲数组
            int load = 0;//接收实际读取大小
            while ((load=is.read(interMedia))!=-1){
                //output as string
                String into = new String(interMedia,0,load);
                System.out.println(into);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取文件失败");
        }finally {
            if(null!=is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭输入流失败！");
                }
            }
        }
    }
}
