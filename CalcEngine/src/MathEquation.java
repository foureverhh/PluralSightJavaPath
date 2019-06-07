public class MathEquation {
    private double leftVal;
    private double rightVal;
    private char opCode;
    private double result;

    public MathEquation(){

    }

    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    public double getLeftVal() {
        return leftVal;
    }

    public double getRightVal() {
        return rightVal;
    }

    public char getOpCode() {
        return opCode;
    }

    public double getResult() {
        return result;
    }

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
