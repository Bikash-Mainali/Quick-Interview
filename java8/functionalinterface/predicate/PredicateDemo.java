package java8.functionalinterface.predicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/21/22
 */
public class PredicateDemo {
    public static void main(String[] args) {

        Predicate<Integer> predicate = (value) -> value < 100 ? true : false;
        System.out.println(predicate.test(12));

        BiPredicate<String, Integer> biPredicate = (param1, param2) -> param1.equals("Biki") && param2 == 10 ? true : false;
        System.out.println(biPredicate.test("BB", 10));

    }
}
