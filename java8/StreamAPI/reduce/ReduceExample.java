package java8.StreamAPI.reduce;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/22/22
 */
public class ReduceExample {
    public static void main(String[] args) {

        //sum
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4);
        Integer sum = stream1.reduce(0, Integer::sum);  // reduce(0, (a,b) -> a + b)
        System.out.println(sum);

        //product
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4);
        Integer mult = stream2.reduce(1, (a, b) -> a * b);
        System.out.println(mult);

        //orElse
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4);
        Optional<Integer> total = stream3.filter(x -> x > 10).reduce((a, b) -> a + b);
        System.out.println(total.orElseGet(() -> null));

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        int s = listOfNumbers.parallelStream().reduce(5, Integer::sum);
        System.out.println(s);  // 30, since the number 5 actually gets added up in every worker thread

        int s1 = listOfNumbers.parallelStream().reduce(0, Integer::sum) + 5;
        System.out.println(s1);  // 15
    }
}
