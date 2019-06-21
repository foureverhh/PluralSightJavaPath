
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class Adder implements Callable<Integer> {

    private String inFile;

    public Adder(String inFile){
        this.inFile = inFile;
    }

    public int doAdd() throws IOException {
        String line = null;
        int total = 0;
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
            while((line = reader.readLine())!= null){
                total += Integer.parseInt(line);
            }
        }
        return total;
    }

    @Override
    public Integer call() throws Exception {

        return doAdd();

    }
}
