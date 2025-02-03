package java8.StreamAPI.max;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/22/22
 */
public class MaxExample {
    public static void main(String[] args) {
        //get the maximum element of the Stream according to the provided Comparator.
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, -25);
        Optional<Integer> maximum = stream1.max(Integer::compareTo); //Comparator.comparing(x -> x)
        //System.out.println(stream1.max(Integer::compare));
        //System.out.println(stream1.mapToInt(x ->x).max().getAsInt());

        System.out.println(maximum.get());

        //the maximum element of the Stream according to the provided Comparator.
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, -25);
        System.out.println(stream2.max(Comparator.reverseOrder()).get());

        //get the maximum element of the Stream according to the provided Comparator.
        //compare by ASCII value
        Stream<String> stream3 = Stream.of("A", "B", "C");
        Optional<String> maxByAsciiValue = stream3.max(Comparator.comparing(x -> x));
        System.out.println(maxByAsciiValue.get());

        //get the maximum element of the Stream according to the provided Comparator.
        //Compare the strings based on their last characters
        Stream<String> stream4 = Stream.of("Bikash", "Bishakha", "Bimal");
        Comparator<String> comparator = Comparator.comparingInt(c -> c.charAt(c.length() - 1));
        Optional<String> maxByLastCharacter = stream4.max(comparator);
        System.out.println(maxByLastCharacter.get());

    }
}
