package java8.StreamAPI.distinct;

import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/22/22
 */
public class DistinctExample {
    public static void main(String[] args) {

        Stream<String> stream = Stream.of("Bikash", "Biki" , "Biki");
        stream.distinct().forEach(System.out::println);
    }
}
