package java8.StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/21/22
 */
public class CustomStream {
    public static void main(String[] args) {
        String arr[] = {"biki", "mainali", "indira", "mainali"};
        //Way 1
        Stream<String> sequentialStream = Stream.of(arr);
        sequentialStream.forEach(System.out::println);
        System.out.println("...........");
        Stream<String> parallelStream = Stream.of(arr);
        parallelStream.parallel().forEach(System.out::println);

        System.out.println(".........");
        //Way 2
        Stream<String> streamByOf = Stream.of("Bikash", "Bimal");
        streamByOf.forEach(System.out::println);

        System.out.println(".........");
        //Way 3 //generates infinite stream
        Stream<String> streamByGenerate = Stream.generate(() -> "Bikash").limit(10);
        streamByGenerate.forEach(System.out::println);

        System.out.println(".........");
        //Way 4
        Stream<Integer> streamByIterate = Stream.iterate(1, (n) -> n + 1).limit(10);
        streamByIterate.forEach(System.out::println);

        System.out.println(".........");

    }

}
