package java8.functionalinterface.customfunctioninterface.reversestring;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 6/23/23
 */
public class ReverseStringWithLamda {
    @FunctionalInterface
    public interface Reverser<T> {
        T reverse(T t);
    }

    public static void main(String[] args) {
        Reverser<String> reverser = x -> new StringBuilder(x).reverse().toString();
        Stream s = Stream.of("Bikash")
                .map(x -> reverser.reverse(x));
        System.out.println(s.collect(Collectors.toList()));

        /**
         *Alternative
         */
        Function<String, String> function = x -> new StringBuilder(x).reverse().toString();
        System.out.println(Stream.of("Bikash")
                .map(function)
                .collect(Collectors.toList()));
    }
}
