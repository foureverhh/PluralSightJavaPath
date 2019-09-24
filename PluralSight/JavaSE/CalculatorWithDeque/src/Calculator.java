import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Calculator {
    /*
    1
    -
    3
    +
    2
    +
    4
    */
    public int evaluate(String input){
        Deque<String> stack = new ArrayDeque<>();
        String[] tokens = input.split("");

            //System.out.println(str);
            stack.addAll(Arrays.asList(tokens));

        int result = 0;
        while(stack.size()>1){
            int left = Integer.parseInt(stack.pop());
            System.out.println("number is: "+left);
            String operator = stack.pop();
            int right = Integer.parseInt(stack.pop());

            switch (operator){
                case "+":
                    result = left + right;
                    break;
                case "-":
                    result = left - right;
                    break;
                default:
                    break;
            }
            System.out.println("Result: "+result);
            stack.push(String.valueOf(result));
        }

        return Integer.parseInt(stack.pop());
    }


}
