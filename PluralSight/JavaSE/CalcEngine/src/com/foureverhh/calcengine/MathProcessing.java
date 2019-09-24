package com.foureverhh.calcengine;

public interface MathProcessing {
     String SEPARATOR = " ";
     String getKeyword();
     char getSymbol();
     double doCalculation(double leftVar, double rightVar);

}
