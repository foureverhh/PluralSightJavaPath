package Streams_part5;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainBuildingStreams {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(0,1,2,3,4);
        Stream<Integer> stream = ints.stream();
        stream.forEach(System.out::println);

        Stream<Integer> stream1 = Stream.of(0,1,2,3,4,5);
        stream1.forEach(System.out::println);

        Stream<String> stringStream1 = Stream.generate(() -> "one");
        stringStream1.limit(5).forEach(System.out::println);

        Stream<String> stringStream2 = Stream.iterate("+", s -> s + " -> ");
        stringStream2.limit(5).forEach(System.out::println);

        IntStream streamOfInt = ThreadLocalRandom.current().ints();
        streamOfInt.limit(5).forEach(System.out::println);

    }
}
