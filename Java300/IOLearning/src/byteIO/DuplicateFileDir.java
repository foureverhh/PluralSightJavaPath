package byteIO;

import java.io.File;
import java.io.IOException;

import static com.oracle.tools.packager.IOUtils.copyFile;

/*
*文件夹的拷贝
* 1.遇到文件就复制 copyFile()
* 2.遇到文件夹就创建 mkdirs()
* 3.递归 查找子孙级
*  */
public class DuplicateFileDir {
    public static void main(String[] args) throws IOException {

/*        String path = "A";
        File dirA = new File(path);
        if(!dirA.exists()){
            dirA.mkdir();
            new File("A/b").mkdir();
            new File("A/a.txt").createNewFile();
            new File("A/b/b.txt").createNewFile();
        }*/
        //Source dir
        String srcPath = "study";

        //target dir
        String tarPath = "dir";
        File src = new File(srcPath);
        File tar = new File(tarPath);

        copyDir(src,tar);
    }

    private static void copyDir(File src,File tar){
        if(src.isDirectory()){
            tar = new File(tar,src.getName());
        }
        copyDirDetails(src,tar);
    }
    private static void copyDirDetails(File src, File tar) {
        if(src.isFile()){
            try {
                copyFile(src,tar);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(src.isDirectory()){
            //Make sure tar exists by making it
            tar.mkdirs();

            for(File subFile : src.listFiles()){
                copyDirDetails(subFile,new File(tar,subFile.getName()));
            }
        }
    }

}
