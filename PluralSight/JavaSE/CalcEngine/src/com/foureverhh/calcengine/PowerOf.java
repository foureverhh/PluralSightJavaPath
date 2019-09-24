package com.foureverhh.calcengine;

public class PowerOf extends CalculateBase implements MathProcessing{
    public PowerOf() {
    }

    public PowerOf(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        double result = Math.pow(getLeftVal(),getRightVal());
        setResult(result);
    }

    @Override
    public String getKeyword() {
        return "power";
    }

    @Override
    public char getSymbol() {
        return '^';
    }

    @Override
    public double doCalculation(double leftVar, double rightVar) {
        setLeftVal(leftVar);
        setRightVal(rightVar);
        calculate();
        return getResult();
    }
}
