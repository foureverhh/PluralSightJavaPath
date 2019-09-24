package com.foureverhh.calcengine;

public class DynamicHelper {
    private MathProcessing[] handlers;

    public DynamicHelper (MathProcessing[] handlers){
        this.handlers = handlers;
    }

    public String process(String statement){
        //IN: "add 1.0 2.0"
        //OUT: 1.0 + 2.0 = 3.0
        String[] parts = statement.split(MathProcessing.SEPARATOR);
        String keyword = parts[0].trim(); //add
        MathProcessing theHandler = null;
        for(MathProcessing handler: handlers){
            if(keyword.equalsIgnoreCase(handler.getKeyword())){
                theHandler = handler;
                break;
            }
        }
        double leftVar = Double.parseDouble(parts[1]); //1.0
        double rightVar = Double.parseDouble(parts[2]); //2.0
        double result = theHandler.doCalculation(leftVar,rightVar);


        StringBuilder sb = new StringBuilder(20);
        sb.append(leftVar);
        sb.append(' ');
        sb.append(theHandler.getSymbol());
        sb.append(' ');
        sb.append(rightVar);
        sb.append(" = ");
        sb.append(result);
        return sb.toString();
    }






}
