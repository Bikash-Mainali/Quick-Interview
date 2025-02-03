package java8.StreamAPI.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/22/22
 */
public class MapExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(11,22,33,55);

        Function<Integer, String> function = (param) -> param > 35 ? "Young" : "Old";
        list.stream().map(function).forEach(System.out::println);
        System.out.println(".....");
        //OR
        list.stream().map((param) -> param > 35 ? "Young" : "Old").forEach(System.out::println);
    }
}
