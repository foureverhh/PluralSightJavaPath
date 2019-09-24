package IODemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        //test1();
        //test2();
        File file = null;
        try {
           file =  test3();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(1000);
        test4(file);
    }


    public static void test4(File file){

        if(file.exists()){
           boolean flag =  file.delete();
            System.out.println(flag ? file+"is deleted":file+" failed to be deleted");
        }
    }
    //Create file
    public static File test3() throws IOException {
        File src = new File("/Users/foureverhh/Java300/IOLearning/data1.txt");
        if(!src.exists()){
            //createNewFile() if file does not exist, return true and create the file
            //if file already exists, return false
            boolean flag = src.createNewFile();
            System.out.println( flag ? "data1.txt created" : "data1 creation failed");
        }
        return src;
    }

    public static void test2(){
        String path = "/Users/foureverhh/Java300/IOLearning/data.txt";
        File src = new File(path);
        System.out.println("data.txt exits "+src.exists());
        System.out.println("data.txt readable "+ src.canRead());
        System.out.println("data.txt writable "+ src.canWrite());
        if(src.isFile()){
            System.out.println(src.getName()+" is a file");
        }
        if(src.isDirectory()){
            System.out.println(src.getName()+" is a directory");
        }
        System.out.println("Check if it is an absolute path: "+src.isAbsolute());

        //.length only works on file not directory
        System.out.println(src.length());
    }

    public static void test1(){
        File src1 = new File("/Users/foureverhh/Java300/IOLearning/test.txt");
        File src2 = new File("data.txt");
        System.out.println(src1.getName());
        System.out.println(src1.getPath());//如果是绝对路径，返回绝对路径，否则返回相对路径
        System.out.println(src1.getAbsolutePath());//返回绝对路径
        System.out.println(src1.getParent());//返回上一级目录，如果是相对，返回null
        System.out.println();
        System.out.println(src2.getName());
        System.out.println(src2.getPath());//如果是绝对路径，返回绝对路径路径，否则返回相对路径
        System.out.println(src2.getAbsolutePath());//返回绝对路径
        System.out.println(src2.getParent());//返回上一级目录，如果是相对路径，返回null
    }
}
