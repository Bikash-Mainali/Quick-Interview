package java8.StreamAPI.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/22/22
 */
public class FilterExample {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>() {{
            add(11);
            add(21);
            add(31);
            add(41);
        }};


        Predicate<Integer> predicate = (param) -> param > 35 ? true : false;
        list.stream().filter(predicate).forEach(System.out::println);
        System.out.println(".....");
        //OR
        list.stream().filter((param) -> {
            return param > 35;
        }).forEach(System.out::println);
    }
}
