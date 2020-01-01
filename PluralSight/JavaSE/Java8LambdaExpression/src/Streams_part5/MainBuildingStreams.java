package Streams_part5;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
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

        Stream.Builder<Integer> streamBuilder = Stream.builder();
        streamBuilder.add(1).add(2).add(3);
        streamBuilder.accept(4);
        Stream myIntStream = streamBuilder.build();
        myIntStream.forEach(System.out::println);

        IntStream charStream = "hello".chars();
        charStream.mapToObj(c -> (char)c).forEach(System.out::println);

        String target = "Test* Java&Letter!!";
        //SplitAsStream split the string around matches and save as Stream<String>
        Stream<String> words = Pattern.compile("[^\\p{javaLetter}]").splitAsStream(target);
        words.forEach(System.out::println);

        try {
            Stream<String> file = Files.lines(Paths.get("test.txt"));
            file.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
