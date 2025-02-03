package java8.StreamAPI;

import LabOfLamdaStream.src.Employee;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 8/23/22
 */

/*
Given a String, find the first repeated character in it using Stream functions?
 */
public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String s = "Hello World";

        IntStream intStream = s.chars();
        Map<Character, Long> map = intStream.mapToObj(x -> Character.toLowerCase(Character.valueOf((char) x)))
                .filter(x -> x != ' ')
                .collect(Collectors.groupingBy(x -> x,Collectors.counting()));
        System.out.println(map);
        Character result = map.entrySet().stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(entry -> entry.getKey())
                .findFirst().get();

        System.out.println("output 1 " + result);


        /*
Given a String, find the first repeated character in it using Stream functions in reverse order
 */

        Character res = map.entrySet().stream()
                .filter(entry -> entry.getValue() > 1L)
                .sorted(Comparator.comparing(x -> x.getKey(), Comparator.reverseOrder()))
                .map(entry -> entry.getKey())
                .findFirst().get();
        System.out.println("output 2 " + res);

    }
}
