package java8.StreamAPI.skip;



import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/22/22
 */
public class SkipExample {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Bikash", "Biki" , "Ramesh");

        //skip first N elements
        stream.skip(2).forEach(System.out::println);
    }
}
