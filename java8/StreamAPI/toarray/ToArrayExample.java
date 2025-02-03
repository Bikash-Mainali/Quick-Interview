package java8.StreamAPI.toarray;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/23/22
 */
public class ToArrayExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Bikash", "Biki", "Ramesh");

        Stream<String> stream = list.stream();

        //String[] strings = stream.toArray(String[]::new);
        String[] strings = stream.toArray(x -> new String[x]);
        System.out.println(Arrays.toString(strings));

    }
}
