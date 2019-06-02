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
    public void cargoFunc (){
        System.out.println("Cargo func");
    }
}