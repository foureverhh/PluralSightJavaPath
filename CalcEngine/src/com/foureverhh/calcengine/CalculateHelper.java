package com.foureverhh.calcengine;

import com.foureverhh.calcengine.Adder;
import com.foureverhh.calcengine.CalculateBase;

import static com.foureverhh.calcengine.MathCommand.*;

public class CalculateHelper {

    private MathCommand command;
    private double leftValue;
    private double rightValue;
    private double result;

    private static final char ADD_SYMBOL = '+';
    private static final char SUBTRACT_SYMBOL = '-';
    private static final char MULTIPLY_SYMBOL = '*';
    private static final char DIVIDE_SYMBOL = '/';

    public void process(String statement) throws InvalidStatementException {
        //add 1.0 2.0
        String[] parts = statement.split(" ");
        if(parts.length != 3)
            throw new InvalidStatementException("Incorrect number of fields", statement);

        String commandString = parts[0];
        try {
            leftValue = Double.parseDouble(parts[1]);
            rightValue = Double.parseDouble(parts[2]);
        }catch (NumberFormatException e){
            throw new InvalidStatementException("Non-numeric data", statement,e);
        }
        setCommandFromString(commandString);
        if(command == null)
            throw new InvalidStatementException("Invalid command",statement);
        CalculateBase calculator = null;
        switch (command){
            case Add:
                calculator =new Adder(leftValue, rightValue);

                break;
            case Subtract:
                calculator =new Substractor(leftValue,rightValue);
                break;
            case Multiply:
                calculator = new Multiplier(leftValue,rightValue);
                break;
            case Divide:
                calculator = new Divider(leftValue, rightValue);
                break;
        }

        calculator.calculate();
        result = calculator.getResult();
    }

    private void setCommandFromString(String commandString){


        if(commandString.equalsIgnoreCase(Add.toString()))
            command = Add;
        else if(commandString.equalsIgnoreCase(Subtract.toString()))
            command = Subtract;
        else if(commandString.equalsIgnoreCase(Divide.toString()))
            command = Divide;
        else if(commandString.equalsIgnoreCase(Multiply.toString()))
            command = Multiply;
    }


    @Override
    public String toString() {
        char symbol = ' ';
        switch (command){
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Subtract:
                symbol = SUBTRACT_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;

        }

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftValue);
        sb.append(' ');
        sb.append(symbol);
        sb.append(' ');
        sb.append(rightValue);
        sb.append(" = ");
        sb.append(result);
        return sb.toString();


    }
}


