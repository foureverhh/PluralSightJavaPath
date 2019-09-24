package bufferedIO;

import java.io.*;

public class BufferedCharDemo {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("target.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("targetBufferedWriter.txt"))){
            String line = null;
            while (null!= (line = reader.readLine())){
                writer.write(line);
//                换行
                writer.newLine();
            }

            writer.append("Append still works");
            writer.flush();//强制换行
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
     /*   try(Reader reader = new BufferedReader(new FileReader("target.txt"));
            Writer writer = new BufferedWriter(new FileWriter("bufferedCharDemo.txt"))){
            char[] buffer = new char[1024];
            int load = 0;
            while (-1!=(load=reader.read(buffer))){
                writer.write(buffer,0,load);
            }
            writer.append("\r\nWriter also appended in the end.");
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
