public class Main {

    public static void main(String[] args) {
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
