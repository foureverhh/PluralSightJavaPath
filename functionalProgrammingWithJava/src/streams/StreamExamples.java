package streams.integerStream;

import java.util.stream.IntStream;

public class StreamExamples {
    public static void main(String[] args) {
        //1.Integer stream
        IntStream
                .range(1,10)
               // .forEach(System.out::print);
                .forEach(n-> System.out.print(n));

        System.out.println();

        //2.Integer Stream with skip
        IntStream
                .range(1,10)
                .skip(5)
                .forEach(n-> System.out.print(n));
        System.out.println();
        //3.Integer Stream with sum
        System.out.println(
                IntStream
                        .range(1,5)
                        .sum()
        );
        System.out.println();


    }
}
