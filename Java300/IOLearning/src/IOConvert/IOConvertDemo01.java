package IOConvert;

import java.io.UnsupportedEncodingException;

public class IOConvertDemo01 {
    public static void main(String[] args) throws UnsupportedEncodingException {
       readPartly();
    }

    public static void encodeAndDecode() throws UnsupportedEncodingException {
        //Decode byte->char
        String str = "中国";
        //Encode char->byte
        byte[] data = str.getBytes();
        String decodedStr = new String(data);
        System.out.println(decodedStr);
        //Try encoding by utf-8
        data = str.getBytes("gbk");
        decodedStr = new String(data);
        System.out.println(decodedStr);
    }

    public static void readPartly(){
        String str = "中国";
        byte[] data = str.getBytes();
        System.out.println(new String(data,0,4));

    }
}
