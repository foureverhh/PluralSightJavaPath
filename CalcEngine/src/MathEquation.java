public class MathEquation {
    public double leftVal;
    public double rightVal;
    public char opCode;
    public double result;

    public double execute(){
        switch (opCode){
                case 'a':
                    return result  = leftVal + rightVal;

                case 'd':
                    return result = rightVal != 0.0d ? leftVal/rightVal : 0.0f;

                case 's':
                    return result = leftVal - rightVal;

                case 'm':
                    return result = leftVal * rightVal;
                 default:
                        System.out.println("Error-invalid opCode");
                        return result = 0.0d;

            }
    }

}
