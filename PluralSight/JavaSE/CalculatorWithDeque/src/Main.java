import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {


    public static void main(String[] args) {
        String input = getInput("number.txt");
        Calculator calculator = new Calculator();
        int result = calculator.evaluate(input);
        System.out.println("Result is: "+result);
    }

    public static String getInput(String file){
        StringBuilder input = new StringBuilder();
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(file))){
            String str = null;
            while((str = reader.readLine())!= null){
                //System.out.println(str);
                input.append(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return input.toString();
    }
}
