import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> sums = new ArrayList<>();
        //List<Integer> frequencies = new ArrayList<>();
        List<Integer> frequencies = getFrequencies();


/*
        frequencies.add(7);

        frequencies.add(7);
        frequencies.add(-2);
        frequencies.add(-7);
        frequencies.add(-4);*/


        boolean findNumber = false;
        int sum =0;
        sums.add(sum);

        //Iterate all elements in frequencies
        for(int index = 0; index <= frequencies.size(); index++) {

            if(index == frequencies.size())
                index = 0;

            sum += frequencies.get(index);

            if (sums.contains(sum)) {
                System.out.print("Found " + sum + " twice");
                break;
            } else
                sums.add(sum);
            //Check results
            /*
            for(int number : sums){
                System.out.print(number+" ");
            }
            System.out.println();
            */
            /*
            int getSameSum = 0;
            for(Integer number : sums){
                //int getSameSum = 0;
                //System.out.println("get 5 at "+sums.indexOf(5));
                if(sum == number){
                    getSameSum++;
                    System.out.println(sum +" "+getSameSum);
                }

                if(getSameSum == 2){
                    System.out.println("Get the 2 times sum:");
                    System.out.println(sum);
                    findNumber = true;
                    break;
                }
            }

            if(findNumber)
                break; */
        }
    }

    //Get all frequencies
    private static List<Integer> getFrequencies(){
        BufferedReader reader;
        List<Integer> numbers = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("number.txt"));
            String line;

            while((line = reader.readLine()) != null){
                int number = Integer.parseInt(line);
                numbers.add(number);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*for(int number: numbers)
            System.out.print(number+" ");
        System.out.println();
         */
        return numbers;
    }
}
