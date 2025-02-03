package java8.StreamAPI.limit;

import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/22/22
 */
public class LimitExample {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Bikash", "Biki" , "Ramesh");
        //returns first N elements
        stream.limit(2).forEach(System.out::println);
    }
}
