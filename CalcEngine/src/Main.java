import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        //double[] leftVals = {100.0d, 25.0d,255.0d,11.0d};

       // double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
       // char[] opCodes = {'d','a','s','m'};
       // double[] results = new double[opCodes.length];

        //MathEquation testEquation = new MathEquation();
        //testEquation.execute();
        //System.out.print("test=");
        //System.out.println(testEquation.getResult());



        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation(100.0d,50.0d,'d');
        equations[1] = new MathEquation(25.0d,92.0d,'a');
        equations[2] = new MathEquation(225.0d,17.0d,'s');
        equations[3] = new MathEquation(11.0d,3.0d,'m');

        for(int i = 0 ; i < equations.length ; i++){
            equations[i].execute();
            System.out.println("Result is: "+equations[i].getResult());

        }

        String[] statements = {
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"
        };





        List<Integer> sums = new ArrayList<>();
        //List<Integer> frequencies = new ArrayList<>();
        List<Integer> frequencies = getFrequencies();


        /*
            frequencies.add(7);

            frequencies.add(7);
            frequencies.add(-2);
            frequencies.add(-7);
            frequencies.add(-4);
        */

        boolean findNumber = false;
        int sum =0;
        sums.add(sum);

        //Iterate all elements in frequencies
        for(int index = 0; index <= frequencies.size(); index++) {

            if(index == frequencies.size())
                index = 0;

            sum += frequencies.get(index);



            sums.add(sum);
            //Check results
            /*
            for(int number : sums){
                System.out.print(number+" ");
            }
            System.out.println();
            */
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
                break;
        }

        //System.out.println(sum);
        /*
        try {
        reader = new BufferedReader(new FileReader("number.txt"));
        String line = reader.readLine();
        while (line != null) {
            int number = Integer.parseInt(line);
            sum += number;
            results.add(sum);
                    int showTime = 0;
                    for(int result :results){
                        if(result == sum)
                            showTime++;
                        if(showTime >1) {
                            System.out.println(sum);
                            break;
                        }
                    }
                    if(showTime>1)
                        break;
                    line = reader.readLine();

                }
                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
*/

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
        for(int number: numbers)
            System.out.print(number+" ");
        System.out.println();
        return numbers;
    }

    static MathEquation create(double leftVal, double rightVal, char opCode) {


        System.out.println();
        System.out.println("Using Overloading");
        System.out.println();

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        MathEquation equationOverload = new MathEquation('d');

        equationOverload.execute(leftDouble, rightDouble);
        System.out.println("Result: "+ equationOverload.getResult());

        int leftInt = 9;
        int rightInt = 4;
        equationOverload.execute(leftInt, rightInt);
        System.out.println("Result: "+ equationOverload.getResult());


        equationOverload.execute((double)leftInt, rightInt);
        System.out.println("Result: "+ equationOverload.getResult());
        System.out.println();
        System.out.println();

        Flight flight = new Flight();
        CargoFlight cargoFlight = new CargoFlight();

        System.out.println("Flight Packages: ");
        System.out.println(flight.packages);
        System.out.println();
        System.out.println("Cargo Packages: ");
        System.out.println(cargoFlight.packages);
        System.out.println();
        System.out.println("Flight get seats: ");
        System.out.println(flight.getSeats());
        System.out.println();
        System.out.println("Cargo get seats ");
        System.out.println(cargoFlight.getSeats());
        System.out.println();

        Flight flightToCargo = new CargoFlight();
        return equationOverload;


    }




    /*
    public static MathEquation create(double leftVal, double rightVal, char opCode){

        MathEquation equation = new MathEquation();
        equation.setLeftVal(leftVal);
        equation.setRightVal(rightVal);
        equation.setOpCode(opCode);

        return equation;
    }
    */

}

class Flight{
    int packages = 200;

    private int seats = 200;
    public int getSeats() {
        return seats;
    }

    public void flightFunc(){
        System.out.println("Flight func");
    }
}

class CargoFlight extends Flight{
    int packages = 10;
    private int seats = 100;
    public int getSeats() {
        return seats;
    }
    public void cargoFunc (){
        System.out.println("Cargo func");
    }
}