package IODemo;

import java.io.File;

/*
* 两个常量
* 1.路径分隔符 ；
* 2.文件分割符 \ windows /linux
* */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);

        //Path expression
        //1.relative path
        RelativePath relativePath = new RelativePath();
        File fileRelative1 = relativePath.src1;
        File fileRelative2 = relativePath.src2;
        System.out.println(fileRelative1);
        System.out.println(fileRelative1);


        System.out.println(fileRelative1.getName());
        System.out.println(fileRelative2.getName());
        System.out.println(fileRelative1.getParent());
        System.out.println(fileRelative2.getParent());
        System.out.println(fileRelative1.getPath());
        System.out.println(fileRelative2.getPath());

        //2.absolute path
        System.out.println();
        AbsolutePath absolutePath = new AbsolutePath();
        File fileAbsolute = absolutePath.src;
        System.out.println(fileAbsolute.getName());
        System.out.println(fileAbsolute.getPath());
        System.out.println(fileAbsolute.getParent());

        //test current path
        System.out.println();
        File currentFile = new File("data.txt");
        System.out.println(currentFile.getPath());
        System.out.println(currentFile.getAbsolutePath());
    }
}

class RelativePath{
    private String parentPath = "E:/xp/p/test";
    private String name1 = "relative1.jpg";
    private String name2 = "relative2.jpg";
    final File src1= new File(parentPath,name1);
    final File src2= new File(parentPath,name2);

}

class AbsolutePath{
    private String path = "E:/xp/p/test/absolute.jpg";
    final File src = new File(path);
}
