package java8.StreamAPI.count;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/22/22
 */
public class CountExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,5);
        System.out.println(list.stream().count());
    }
}
