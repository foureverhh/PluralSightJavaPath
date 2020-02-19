package linear_structure.deque_sample;

/*
* 十进制转化为二进制
*
* */

import java.util.Deque;
import java.util.LinkedList;

public class TestConverter {
    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        int number = 15;

        while (number > 0){
            stack.push(number % 2 );
            number = number / 2;
        }

        stack.forEach(System.out::print);
    }
}
