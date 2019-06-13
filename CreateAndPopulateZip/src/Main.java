import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        /*
        //invoke doWrite();
        try {
            doWrite(13,11,4,2,1.0d);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
/*
        //replaceAll
        String s1 = "apple， apple， and orange please";
        String s2 = s1.replaceAll("ple","ricot");
        System.out.println(s1);
        System.out.println(s2);

        String s3 = s1.replaceAll("ple\\b","ricot");
        System.out.println(s3);
        String s4 = s1.replaceAll("ple\\B","ricot");
        System.out.println(s4);

 */

/*
        //Split and match Methods
        String s1 = "apple， apple， and orange please";
        String[] parts = s1.split("\\b");

        for(String part : parts){
            System.out.println(part);
        }
        System.out.println("with \\w");
        for(String part : parts){
            if(part.matches("\\w+"))
                System.out.println(part);
        }

 */

        //patternAndMatcher();

    /*
        //By default collections hold Object types, so not type restricted
        ArrayList list = new ArrayList();
        list.add("a");
        list.add(123);
        list.add(12.34d);
        System.out.println(list.size());
        for(Object obj:list){
            System.out.println(obj.toString());
        }

        //Type-restricted collection
        ArrayList<String> restrictedArray = new ArrayList<>();
        restrictedArray.add("Foo");
        restrictedArray.add("Bar");
        for(String str:restrictedArray){
            System.out.println(str);
        }

        //addAll
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("B");
        list2.add("C");
        list2.add("D");

        list1.addAll(list2);
        System.out.println("addAll()");
        for(String str: list1){
            System.out.print(str+" ");
        }
        System.out.println();
        //retainAll 取交集
        list1.retainAll(list2);
        System.out.println("retainAll():");
        for(String str: list1){
            System.out.print(str+ " ");
        }
        System.out.println();

    */
    /*
        //equals will compare value
        ArrayList<MyClass> list = new ArrayList<>();
        MyClass v1 = new MyClass("v1","abc");
        MyClass v2 = new MyClass("v2","abc");
        MyClass v3 = new MyClass("v3","abc");
        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.remove(v3);
        for(MyClass item : list){
            System.out.println(item.getLabel());
        }
    */
    /*
        //Lambda forEach() removeIf()
        ArrayList<MyClass> list = new ArrayList<>();

        MyClass v1 = new MyClass("v1","abc");
        MyClass v2 = new MyClass("v2","xyz");
        MyClass v3 = new MyClass("v3","abc");

        list.add(v1);
        list.add(v2);
        list.add(v3);

        //list.forEach( m -> System.out.println(m.getLabel()));
        list.removeIf( m -> m.getValue().equals("abc"));
        list.forEach(n-> System.out.println(n.getLabel()));
    */
    /*  array and collections conversion
        //convert a list to array
        ArrayList<MyClass> classList = new ArrayList<>();

        MyClass v1 = new MyClass("v1","abc");
        MyClass v2 = new MyClass("v2","xyz");
        MyClass v3 = new MyClass("v3","abc");
         //Object[] objectArray = list.toArray(); return an array in Object
        //Object[] objArray = classList.toArray();
        //T[] to Array(T[] a)
        classList.add(v1);
        classList.add(v2);
        classList.add(v3);
        MyClass[] newArray1 = new MyClass[classList.size()];
        newArray1 = classList.toArray(newArray1);
       // MyClass[] newArray2 = list.toArray(new MyClass[4]);
        for(MyClass item: newArray1){
            System.out.println(item.getLabel() + " " + item.getValue());
        }
        //Retrieving a Collection from an Array
        MyClass[] myArray = {
            new MyClass("val1","abc"),
            new MyClass("val2","xyz"),
            new MyClass("val3","abc")
        };
        Collection<MyClass> newList = Arrays.asList(myArray);
        newList.forEach(list -> System.out.println(list.getLabel() + " " + list.getValue()));
    */
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



    private static void patternAndMatcher(){
        //Pattern and Matcher Classes
        String value1 = "apple, apple and orange please";
        System.out.println("Pattern and Matcher Classes");
        Pattern pattern = Pattern.compile("\\w+");

        Matcher matcher = pattern.matcher(value1);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
