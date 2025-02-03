package java8.functionalinterface.consumer.demo4;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/20/22
 */
public class Main {
    public static void main(String[] args) {
        Collection<String> list =  new ArrayList<>(){{
            add("Bikash");
            add("BB");
            add("CC");
            add("DD");
        }};

        list.forEach((x) -> System.out.println(x));
    }
}
