package bufferedIO;

import java.io.*;

public class Demo02 {
    public static void main(String[] args) {
        try(Writer writer = new FileWriter(new File("targetChar02.txt"))){
            String message = "锄禾日当午，汗滴禾下午\r\nTest WRITER";
            writer.write(message);
            writer.append("Info to append: write.append(info);\r\n");
            String messageAfterAppend = "TEST writer.write() after write.append()";
            writer.write(messageAfterAppend);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
