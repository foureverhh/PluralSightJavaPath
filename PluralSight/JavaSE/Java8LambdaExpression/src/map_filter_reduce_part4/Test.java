package map_filter_reduce_part4;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Test {

    public static int reduce(List<Integer> list, int valueIfEmpty, BinaryOperator<Integer> reduction){
        int result = valueIfEmpty;
        for(Integer integer : list){
            result = reduction.apply(result ,integer);
        }

        return result;
    }
    public static void main(String[] args) {
  /*      List<Integer> integers = Arrays.asList(-1,-2);
        int sum = 0;
        int max = Integer.MIN_VALUE;
        BinaryOperator<Integer> opSum = Integer::sum;
        BinaryOperator<Integer> opMax = Integer::max;
        for(Integer i : integers){
            sum = opSum.apply(sum, i);
        }
        System.out.println(sum);

        for(Integer i : integers){
            max = opMax.apply(max, i);
        }
        System.out.println(max);*/
        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> ints1 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> ints2 = Arrays.asList(5, 6, 7, 8, 9);

        BinaryOperator<Integer> op = Integer::max; //(i1,i2) -> (i1 + i2) / 2; //i1;//Integer::sum;

        int reduction1 = reduce(ints1, 0, op);
        int reduction2 = reduce(ints2, 0, op);
        int reduction = reduce(Arrays.asList(reduction1, reduction2), 0, op);
        int reductionCompare = reduce(ints, 0, op);
        System.out.println("Reduction : " + reduction1);
        System.out.println("Reduction : " + reduction2);
        System.out.println("Reduction : " + reduction + " " + reductionCompare);
        //System.out.println("Reduction : " + reduction3);

        List<Integer> list = ints.stream().map(number -> number * 2).collect(Collectors.toList());
        System.out.println(ints);
        System.out.println(list);

    }

}
