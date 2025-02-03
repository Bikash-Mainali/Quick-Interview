package java8.StreamAPI.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 11/13/23
 */
public class OtherExamples {

    public static void main(String[] args) {
        List<String> list = Arrays.asList();

        // isPresentOrElse
        list.stream()
                .findFirst()
                .ifPresentOrElse(
                        (emp) -> System.out.printf("Value is present, its: %s%n", emp),
                        () -> System.out.println("Value is empty"));

        //ofNullable
        //ofNullable returns empty optional instance if specified value is null
        List<Optional> optional1 = list.stream()
                .map(Optional::ofNullable)
                .collect(Collectors.toList());   // map(Optional::ofNullable)

        //orElse and Optional.of()
        System.out.printf("orElse and Optional.of(): %s%n",
                optional1.stream()
                        .findFirst()
                        .orElse(getTestString()));


        List<Optional> optional2 = new ArrayList<>().stream()
                .map(Optional::ofNullable)
                .collect(Collectors.toList());   // map(Optional::ofNullable)


        //orElseGet
        System.out.printf("orElseGet: %s%n",
                optional2.stream()
                        .findFirst()
                        .orElseGet(() -> getTestString()));
        //orElseThrow
        System.out.printf("orElseThrow: %s%n",
                optional2.stream()
                        .findAny()
                        .orElseThrow(() -> new RuntimeException("No value present!!!!!!!!!"))
        );

    }

    public static Optional getTestString(){
        return Optional.of("Test String");
    }

}
