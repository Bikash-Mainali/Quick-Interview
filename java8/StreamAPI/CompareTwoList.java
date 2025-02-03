package java8.StreamAPI;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 8/23/22
 */
public class CompareTwoList {
    public static void main(String[] args) {
        String[] s1 = new String[]{"Dogs", "Cat", "Pony", "Rat"};
        String[] s2 = new String[]{"Giraffe", "Cat", "Pony", "Donkey"};

        Stream<String> stream = Stream.of(s1)
                .filter(x -> !Stream.of(s2).collect(Collectors.toList()).contains(x));
        System.out.println(stream.collect(Collectors.toList()));
    }
}
