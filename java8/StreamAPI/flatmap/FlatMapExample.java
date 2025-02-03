package java8.StreamAPI.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/22/22
 */
public class FlatMapExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Joe", "Tom", "Abe");

        //use of map
        Stream<Stream<Character>> streamStream1 = list.stream().map(x -> getCharacterStream(x));
        streamStream1.forEach(x -> x.forEach(System.out::print));
        System.out.println("........");

        //use of flat map
        Stream<Character> streamStream2 = list.stream().flatMap(x -> getCharacterStream(x));
        streamStream2.forEach(System.out::print);
    }

    public static Stream<Character> getCharacterStream(String s) {
        List<Character> characterList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            characterList.add(c);
        }
        return characterList.stream();
    }
}
