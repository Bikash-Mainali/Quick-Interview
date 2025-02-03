package java8.functionalinterface.customfunctioninterface;

import org.w3c.dom.ls.LSOutput;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/21/22
 */
public class Main {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> triFunction = new TriFunction<Integer, Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer s, Integer t, Integer u) {
                return s + t + u;
            }
        };

        /**
         * Shorthand: TriFunction<Integer, Integer, Integer, Integer> triFunction = (x, y, z) -> x + y + z;
         * OR
         * ((TriFunction<Integer, Integer, Integer, Integer>) (x, y, z) -> x + y + z).apply(12,11,14);
         */
        System.out.println(triFunction.apply(12, 11, 14));
    }
}
