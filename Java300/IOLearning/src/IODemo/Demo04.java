package IODemo;

import java.io.File;
import java.util.Arrays;

//List parent files or directory
public class Demo04 {
    public static void main(String[] args) {
        String path ="/Users/foureverhh/Java300/IOLearning/parent1/";
        File file = new File(path);
        System.out.println("Print all files and directory");
        //traversalFiles(file);
        File[] roots = File.listRoots();
        System.out.println(Arrays.toString(roots));
    }

    public static void traversalFiles(File file){

        if(file.exists() && file.listFiles()!=null && file.listFiles().length!=0){
            System.out.println("In file "+file.getName()+" has:");
            Arrays.stream(file.listFiles())
                    .forEach(f-> System.out.print(f.getName()+" "));
            System.out.println();
            for(File subFile: file.listFiles())
                traversalFiles(subFile);
        }


    }
}
