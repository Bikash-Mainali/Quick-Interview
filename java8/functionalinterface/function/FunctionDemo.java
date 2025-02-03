package java8.functionalinterface.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/21/22
 */
public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, String> function = (s) -> s;
        System.out.println(function.apply("Name"));

        BiFunction<Double, Double, Double> biFunction = (param1, param2) -> param1 + param2;
        System.out.println(biFunction.apply(12.00, 120.55));
    }
}
