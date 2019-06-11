import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] data = {
               "Line 1",
               "Line 2 2",
               "Line 3 3 3",
               "Line 4 4 4 4"
        };
/*
        try(FileSystem zipFs = openZip(Paths.get("myData.zip"))){
            copyToZip(zipFs);
            writeToFileZip1(zipFs,data);
            writeToFileZip2(zipFs,data);

        }catch (Exception e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

*/

        /***********Tested StringJoiner ****************/
        /*
        StringJoiner sj = new StringJoiner(", ","Items : "," !");;
        for(String str : data){
            sj.add(str);
        }
        System.out.println(sj.toString());

        StringJoiner sj1 = new StringJoiner(" , "," [ "," ] ");
        System.out.println(sj1.toString());

        StringJoiner sj2 = new StringJoiner(" , "," [ "," ] ");
        sj2.setEmptyValue("HARD");
        sj2.add("Soft");
        System.out.println(sj2.toString());
        */

        /****************** String Format ****************/
        /*
        int david = 13, dawson = 11111111, dillon = 4, gordon =2;
        String str1 = "My nephews are " + david + ", " + dawson + ", " + dillon + ", and " + gordon + " years old.";
        String str2 = String.format("My nephews are %d, %d, %d, and %d years old.",david,dawson,dillon,gordon);
        System.out.println(str1);
        System.out.println(str2);

        double avgDiff = ((david - dawson) + (dawson - dillon) + (dillon - gordon)) / 3.0d;
        String str3 = "The average age between each is " + avgDiff + " years.";
        System.out.println(str3);
        String str4 = String.format("The average age between each is %,010.2f years.",avgDiff);
        System.out.println(str4);

        int i = 123456, j= 34567890;
        double k = -234456.78973;
        System.out.printf("i is %,d.",i);
        System.out.println();
        System.out.printf("k is %(,.2f.",k);
        System.out.println();
        */

        /**************************************** Argument Index  ****************************************/
        /*
        System.out.printf("Print string %s, %s and %s", "A","B","C");
        System.out.println();
        System.out.printf("Print string %2$s, %1$s and %2$s", "A","B","C");
        System.out.println();
        System.out.printf("Print string %3$s, %<s and %1$s", "A","B","C");
        */

        try {
            doWrite(13,11,4,2,1.0d);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException{

        Map<String,String> providerProps = new HashMap<>();
        providerProps.put("create","true");
        URI zipUri = new URI("jar:file", zipPath.toUri().getPath(),null);
        FileSystem zipFs = FileSystems.newFileSystem(zipUri,providerProps);
        return zipFs;
    }

    private static void copyToZip(FileSystem zipFs) throws IOException{
        Path sourceFile = Paths.get("file1.txt");
        //Path sourceFile = FileSystems.getDefault().getPath("file1.txt");
        Path destinationFile = zipFs.getPath("/file1Copied.txt");

        Files.copy(sourceFile,destinationFile,StandardCopyOption.REPLACE_EXISTING);

    }

    private static void writeToFileZip1(FileSystem zipFs,String[] data)throws IOException{
        try(BufferedWriter writer = Files.newBufferedWriter(zipFs.getPath("/newFile1.txt"),StandardOpenOption.APPEND)){
            for(String str: data){
                writer.write(str);
                writer.newLine();
            }
        }catch (Exception e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

    }

    private static void writeToFileZip2(FileSystem zipFs,String[] data) throws IOException{
       /*
       try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("newFile2.txt"));){
            for(String str: data){
                writer.write(str);
                writer.newLine();
            }
        }catch (Exception e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        */
       Files.write(Paths.get("newFile2Test.txt"), Arrays.asList(data), Charset.defaultCharset(),StandardOpenOption.CREATE);
    }

    /********************Writing Formatted Content to a Stream ****************************************/
    static void doWrite(int david, int dawson, int dillon, int gordon, double avgDiff) throws IOException{
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("MyFile.txt"));
        try(Formatter f = new Formatter(writer)){
            f.format("My nephews are %d, %d, %d, and %d years old",david,dawson,dillon,gordon);
            f.format("\n");
            f.format("The average age between each is %.1f years",avgDiff);
        }
    }
}
