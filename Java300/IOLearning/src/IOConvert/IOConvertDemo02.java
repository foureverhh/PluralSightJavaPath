package IOConvert;

import java.io.*;

/*
* 转换流: byte->char
* 1.输出流：OutputStreamWriter
* 2.输入流：InputStreamReader
* */
public class IOConvertDemo02 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //Make the file decode as utf-8 format, InputStreamReader
        BufferedReader reader = new BufferedReader(
                                    new InputStreamReader(
                                            new FileInputStream(new File("target.txt")),"UTF-8"
                                    )
        );
    }
}
