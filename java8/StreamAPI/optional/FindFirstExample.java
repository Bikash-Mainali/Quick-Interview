package java8.StreamAPI.optional;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/22/22
 */
public class FindFirstExample {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2 , 3);
        Optional<Integer> first = stream.filter(x -> x > 5).findFirst();
        System.out.println(first.get());
    }
}
