package IODemo;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.util.Arrays;

/*
* mkdir parent must exists
* mkdirs create multi tier files
* */
public class Demo03 {
    public static void main(String[] args) {
        String path1 = "/Users/foureverhh/Java300/IOLearning/parent1";
        File file1 = new File(path1);
        file1.mkdirs();
        if(file1.isDirectory()){
            System.out.println("Lists of "+file1);
            Arrays.stream(file1.list())
            .forEach(System.out::println);
            System.out.println();
            System.out.println("List File of "+file1);
            Arrays.stream(file1.listFiles())
                    .forEach(System.out::println);

        }
    }
}
