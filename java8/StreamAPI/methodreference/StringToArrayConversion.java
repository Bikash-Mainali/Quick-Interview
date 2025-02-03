package java8.StreamAPI.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/22/22
 */
public class StringToArrayConversion {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Bikash", "Biki", "Ramesh");

        Stream<String> stream = list.stream();

        //String[] strings = stream.toArray(String[]::new);
        String[] strings = stream.toArray(x -> new String[x]);
        System.out.println(Arrays.toString(strings));
    }
}
