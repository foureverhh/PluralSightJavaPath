import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String[] data = {
               "Line 1",
               "Line 2 2",
               "Line 3 3 3",
               "Lin4 4 4 4"
        };

        try(FileSystem zipFs = openZip(Paths.get("myData.zip"))){
            copyToZip(zipFs);
        }catch (Exception e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
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
        Path destinationFile = zipFs.getPath("file1Copied.txt");

        Files.copy(sourceFile,destinationFile,StandardCopyOption.REPLACE_EXISTING);

    }

    private static void writeToFileZip1(FileSystem zipFs,String[] data)throws IOException{

    }

    private static void writeToFileZip2(FileSystem zipFs,String[] data) throws IOException{

    }
}
