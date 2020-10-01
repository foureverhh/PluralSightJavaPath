package lesson276_dynamic_complie;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Demo {
    public static void main(String[] args) {
        //通过IO流将String转为临时文件
        String string = "public class Hi {" +
                            "public static void main(String[] a){ " +
                                    "System.out.println(\"how are you?\");" +
                            "}" +
                        " }";
        String path ="/Users/foureverhh/java_compiler_file/";


        //获取java compiler
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null,null,null, path + "HelloWorld.java");
        System.out.println(result ==0 ? "编译成功" : "编译失败");
        System.out.println(compileString(string,path + "Hi.java") == 0 ? "编译成功" : "编译失败");

        String command1 = "java -cp " + path + " HelloWorld";
        String command2 = "java -cp " + path + " Hi";
        //handle with runtime
        handleWithRuntime(command1);
        handleWithRuntime(command2);

        //handle with reflection with URLClassLoader
        handleWithClassLoader(path,"HelloWorld");
        handleWithClassLoader(path,"Hi");

    }

    static int compileString(String source, String path){
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(path))){
            writer.write(source);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return compiler.run(null,null,null,path);
    }

    static void handleWithRuntime(String command){
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(command);
            InputStream in = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String message= "";
            //StringBuilder sb = new StringBuilder();
            while (null != (message = reader.readLine())){
                //sb.append(message);
                System.out.println(message);
            }
            //System.out.println(sb.toString());
            //runtime.exec(command2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void handleWithClassLoader(String dir,String fileName){
        try {
            URL[] urls = new URL[]{new URL("file:" + dir)};
            URLClassLoader loader = new URLClassLoader(urls);

            Class<?> clz = loader.loadClass(fileName);
            //调用加载类的class
            clz.getMethod("main",String[].class).invoke(null,(Object)new String[]{});
            //！！！！知识点！！！！
            //main方法是静态的，所以不需要目标object，因此invoke的第一个入参是null
            //（Object）new String[]{} 表示将new String[]{}作为一个object的入参
            //等同于main（new String[] args）{}

            //如果写为 new String[]{}，比如 new String[]{"a","b"}
            //等同于main（"a","b"), 则"a"， "b"作为main的人入参
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
