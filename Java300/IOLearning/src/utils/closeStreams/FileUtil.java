package utils.closeStreams;

import java.io.Closeable;
import java.io.IOException;

/*
*
* ... 必须放在所有参数的最后，会被作为数组处理
* */
public class FileUtil {

    public static void close(Closeable...io) throws IOException {
        for(Closeable temp: io){
            if(null!=temp){
                temp.close();
            }
        }
    }

}
