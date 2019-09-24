package com.foureverhh.calcengine;

import com.foureverhh.calcengine.CalculateBase;

public class Divider extends CalculateBase {
    public Divider(){

    }
    public Divider(double leftValue, double rightValue){
        super(leftValue,rightValue);
    }
    @Override
    public void calculate() {
        setResult(getLeftVal()/getRightVal());
    }
}
